package controller;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.UIManager;

import component.DatePicker;
import model.Task;
import model.User;
import services.TaskService;
import services.UserService;
import view.AddNewTaskView;
import view.ChangePasswordView;
import view.DashboardView;
import view.HistoryView;
import view.LoginView;
import view.RegisterView;

public class MainController {

	private final static String MEMORY_TYPE = "InMem";
	private final static int LIST_CAPACITY = 50;
	
	private UserService userService;
	private TaskService taskService;

	private LoginView loginView;
	private RegisterView registerView;
	private DashboardView dashboardView;
	private ChangePasswordView changePasswordView;
	private HistoryView historyView;
	private AddNewTaskView addNewTaskView;
	private DatePicker datePicker;

	private int lastInsertedUserIndex = 0;
	private int lastInsertedTaskIndex = 0;
	private User currentUser;

	public void start() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		loginView = new LoginView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		registerView = new RegisterView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		dashboardView = new DashboardView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		changePasswordView = new ChangePasswordView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		historyView = new HistoryView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		addNewTaskView = new AddNewTaskView((int) screenSize.getWidth(), (int) screenSize.getHeight());
		
		userService = new UserService(MEMORY_TYPE);
		taskService = new TaskService(MEMORY_TYPE);
		
		if(userService.size() != 0) {
			lastInsertedUserIndex = userService.lastInsertedIndex();
		}
		
		if(taskService.size() != 0) {
			lastInsertedTaskIndex = taskService.lastInsertedIndex();
		}
	
		initializeButtonListeners();
		loginView.setVisible(true);
	}

	private void initializeButtonListeners() {
		loginView.addLoginButtonActionListener(e -> {
			final String username = loginView.getUsername();
			final String password = loginView.getPassword();
			final User user = userService.get(username);

			if (validateLogin(username, password, user)) {
				loginView.setVisible(false);

				currentUser = user;

				dashboardView.setWelcomeLabel(user.getFirstName() + " " + user.getLastName());

				List<String> todayTasksList = new ArrayList<String>();
				List<String> upcomingTasksList = new ArrayList<String>();
				List<Task> tasks = taskService.getByUserUsername(user.getUsername());
				Iterator<Task> it = tasks.iterator();

				while (it.hasNext()) {
					Task task = it.next();

					switch (validateDueDate(task.getDueDate())) {
					case 0:
						todayTasksList.add(task.getDescription());
						break;
					case 1:
						upcomingTasksList.add(task.getDescription());
						break;
					}
				}

				String[] todayStringList = new String[LIST_CAPACITY];
				String[] upcomingStringList = new String[LIST_CAPACITY];

				todayStringList = todayTasksList.toArray(todayStringList);
				upcomingStringList = upcomingTasksList.toArray(upcomingStringList);

				dashboardView.setTodayModel(todayStringList);
				dashboardView.setUpcomingModel(upcomingStringList);

				dashboardView.resetSelectedIndexTodayList();
				dashboardView.resetSelectedIndexUpcomingList();
				dashboardView.setVisible(true);

				System.out.println("Logged in");
			} else {
				System.out.println("Login error!");
			}
		});

		loginView.addNotRegisteredButtonActionListener(e -> {
			loginView.setVisible(false);
			registerView.clearRegisterTextFields();
			registerView.setVisible(true);
			System.out.println("Register");
		});

		loginView.addPasswordToggleButtonMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				loginView.hidePassword();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				loginView.displayPassword();
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
			}

		});

		registerView.addRegisterButtonActionListener(e -> {
			final User user = new User();

			final String firstName = registerView.getFirstName();
			final String lastName = registerView.getLastName();
			final String username = registerView.getUsername();
			final String password = registerView.getPassword();

			user.setId(++lastInsertedUserIndex);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setPassword(password);

			if (validateRegister(firstName, lastName, username, password)) {
				userService.create(user);
				System.out.println("'" + username + "' succesfully registered!");

				registerView.setVisible(false);
				loginView.clearLoginTextFields();
				loginView.setVisible(true);
			} else {
				System.out.println("Register error!");
			}
		});

		dashboardView.addAddTaskButtonActionListener(e -> {
			addNewTaskView.resetTextFields();
			addNewTaskView.setVisible(true);
			System.out.println("Adding a new task");
		});

		dashboardView.addTodayTasksListSelectionListener(e -> {
			dashboardView.resetSelectedIndexUpcomingList();
		});

		dashboardView.addUpcomingTasksListSelectionListener(e -> {
			dashboardView.resetSelectedIndexTodayList();
		});

		dashboardView.addDeleteTaskButtonActionListener(e -> {
			int indexToday = dashboardView.getTodayTasksSelectedIndex();
			int indexUpcoming = dashboardView.getUpcomingTasksSelectedIndex();

			if (indexToday >= 0 && indexUpcoming == -1 && !dashboardView.isTodayListSelectionEmpty()) {
				String taskDescription = dashboardView.getTodayTask(indexToday);
				taskService.removeByDescription(taskDescription);

				dashboardView.removeTaskTodayList(indexToday);

				System.out.println("Task '" + taskDescription + "' deleted");
			} else if (indexToday == -1 && indexUpcoming >= 0 && !dashboardView.isUpcomingListSelectionEmpty()) {

				String taskDescription = dashboardView.getUpcomingTask(indexUpcoming);
				taskService.removeByDescription(taskDescription);

				dashboardView.removeTaskUpcomingList(indexUpcoming);

				System.out.println("Task '" + taskDescription + "' deleted");
			}
		});

		dashboardView.addLogoutButtonActionListener(e -> {
			dashboardView.clearTaskLists();
			dashboardView.setVisible(false);
			loginView.clearLoginTextFields();
			loginView.setVisible(true);
			System.out.println("Logged out");
		});

		dashboardView.addChangePasswordButtonActionListener(e -> {
			changePasswordView.clearTextFields();
			changePasswordView.setVisible(true);
			System.out.println("Changing password");
		});
		
		dashboardView.addHistoryButtonActionListener(e -> {
			List<Task> tasks = taskService.getByUserUsername(currentUser.getUsername());
			Iterator<Task> it = tasks.iterator();
			
			String[][] data = new String[tasks.size()][2];
			
			int i = 0;
			while(it.hasNext()) {
				Task newTask = it.next();
				data[i][0] = newTask.getDescription();
				data[i++][1] = newTask.getDueDate();
			}
			
			historyView.setTableModel(data);			
			
			historyView.setVisible(true);
			System.out.println("Browsing history");
		});

		addNewTaskView.addPickButtonEventListener(e -> {
			datePicker = new DatePicker(addNewTaskView);
			addNewTaskView.setDateTextField(datePicker.setPickedDate());

			System.out.println("Due date chosen");
		});

		addNewTaskView.addSaveButtonEventListener(e -> {
			String dueDate = addNewTaskView.getDueDate();
			String description = addNewTaskView.getDescription();

			Task task = new Task();
			task.setId(++lastInsertedTaskIndex);
			task.setDescription(description);
			task.setDueDate(dueDate);
			task.setUserUsername(currentUser.getUsername());
			
			if (validateAddTask(description, dueDate)) {

				switch (validateDueDate(dueDate)) {
				case 0:
					dashboardView.addTodayTask(description);
					addNewTaskView.setVisible(false);
					addNewTaskView.resetTextFields();
					System.out.println("New task added: '" + task.getDescription() + "'");
					taskService.create(task);
					break;
				case 1:
					dashboardView.addUpcomingTask(description);
					addNewTaskView.setVisible(false);
					addNewTaskView.resetTextFields();
					System.out.println("New task added: '" + task.getDescription() + "'");
					taskService.create(task);
					break;
				default:
					addNewTaskView.displayMessage("Invalid due date!");
					System.out.println("Add a new task error!");
					break;
				}
			}
		});

		addNewTaskView.addCancelButtonEventListener(e -> {
			addNewTaskView.resetTextFields();
			addNewTaskView.setVisible(false);
			System.out.println("Cancelled adding a new task");
		});

		changePasswordView.addSubmitButtonActionListener(e -> {
			String currentPassword = changePasswordView.getCurrentPassword();
			String newPassword = changePasswordView.getNewPassword();
			if (validateCurrentPassword(currentUser.getPassword(), currentPassword)) {
				if (validateNewPassword(currentPassword, newPassword)) {
					currentUser.setPassword(newPassword);
					userService.update(currentUser);

					System.out.println("'" + currentUser.getUsername() + "' changed password succesfully!");
					changePasswordView.setVisible(false);
				}
			}
		});
	}

	private boolean validateCurrentPassword(String password, String currentPassword) {
		if (!password.equals(currentPassword)) {
			changePasswordView.displayMessage("Invalid current password");
			return false;
		}
		return true;
	}

	private boolean validateNewPassword(String currentPassword, String newPassword) {
		if (currentPassword.equals(newPassword)) {
			changePasswordView.displayMessage("New password must be different");
			return false;
		}
		return true;
	}

	public boolean validateLogin(String username, String password, User user) {
		if (user == null || password.equals("") || username.equals("") || !user.getUsername().equals(username)
				|| !user.getPassword().equals(password)) {
			loginView.displayMessage("Username or password are not correct");
			return false;
		}
		return true;
	}

	public boolean validateRegister(String firstName, String lastName, String username, String password) {
		if (firstName.equals("") || lastName.equals("") || username.equals("") || password.equals("")) {
			registerView.displayMessage("Invalid input data");
			registerView.clearRegisterTextFields();
			return false;
		}

		if (userService.get(username) != null) {
			registerView.displayMessage("Username already in use!");
			return false;
		}

		return true;
	}

	public boolean validateAddTask(String description, String dueDate) {
		if (description.equals("")) {
			addNewTaskView.displayMessage("No description added!");
			return false;
		}

		if (dueDate.equals("")) {
			addNewTaskView.displayMessage("No due date added!");
			return false;
		}

		String pattern = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
		if (!dueDate.matches(pattern)) {
			addNewTaskView.displayMessage("Invalid due date format!");
			return false;
		}

		return true;
	}

	public int validateDueDate(String dueDate) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = dateFormat.format(new Date());

		Date curDate = null;
		Date duDate = null;

		try {
			curDate = dateFormat.parse(currentDate);
			duDate = dateFormat.parse(dueDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (duDate.compareTo(curDate) == 0) {
			return 0;
		} else if (duDate.after(curDate)) {
			return 1;
		}

		return -1;
	}
}
