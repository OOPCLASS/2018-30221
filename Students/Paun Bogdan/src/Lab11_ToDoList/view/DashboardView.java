package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;

// check this for creating a list of elements - http://www.java2s.com/Code/Java/Swing-Components/CheckListExample2.htm

public class DashboardView extends JFrame {

	private static final long serialVersionUID = -754961072607056889L;

	private JLabel lblWelcomeFirstName;
	private JButton btnAddTask;
	private JButton btnDeleteTask;
	private JButton btnLogout;
	private JButton btnChangePassword;
	private JButton btnHistory;
	private JList<String> todayTasksList;
	private JList<String> upcomingTasksList;
	private DefaultListModel<String> todayModel;
	private DefaultListModel<String> upcomingModel;

	private final static int windowWidth = 550;
	private final static int windowHeight = 500;

	public DashboardView(int widthOrigin, int heightOrigin) {

		this.setTitle("Dashboard");
		this.setResizable(false);

		this.setBounds(widthOrigin / 2 - windowWidth / 2, heightOrigin / 2 - windowHeight / 2, 611, 530);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblWelcomeFirstName = new JLabel("Welcome, first-name");
		lblWelcomeFirstName.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblWelcomeFirstName.setBounds(59, 28, 341, 39);
		getContentPane().add(lblWelcomeFirstName);

		JLabel lblHereAreYour = new JLabel("Here are your tasks for:");
		lblHereAreYour.setBounds(59, 78, 187, 14);
		getContentPane().add(lblHereAreYour);

		JLabel lblToday = new JLabel("Today");
		lblToday.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblToday.setBounds(58, 122, 46, 14);
		getContentPane().add(lblToday);

		JLabel lblDays = new JLabel("Upcoming days");
		lblDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDays.setBounds(361, 122, 123, 14);
		getContentPane().add(lblDays);

		/* Todays tasks List */
		todayModel = new DefaultListModel<String>();

		todayTasksList = new JList<String>(todayModel);
		todayTasksList.setVisibleRowCount(20);
		todayTasksList.setBounds(58, 118, 187, 254);
		todayTasksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		todayTasksList.setLayoutOrientation(JList.VERTICAL);
		getContentPane().add(todayTasksList);

		JScrollPane scrollBarTodayTasksList = new JScrollPane(todayTasksList);
		scrollBarTodayTasksList.setBounds(58, 147, 187, 254);
		getContentPane().add(scrollBarTodayTasksList);

		/* Upcoming tasks List */
		upcomingModel = new DefaultListModel<String>();

		upcomingTasksList = new JList<String>(upcomingModel);
		upcomingTasksList.setVisibleRowCount(20);
		upcomingTasksList.setBounds(297, 118, 187, 254);
		upcomingTasksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		upcomingTasksList.setLayoutOrientation(JList.VERTICAL);
		getContentPane().add(upcomingTasksList);

		JScrollPane scrollBarUpcomingTaskslist = new JScrollPane(upcomingTasksList);
		scrollBarUpcomingTaskslist.setBounds(352, 147, 187, 254);
		getContentPane().add(scrollBarUpcomingTaskslist);

		/* Add task button */
		btnAddTask = new JButton("Add task");
		btnAddTask.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddTask.setForeground(Color.BLACK);
		btnAddTask.setBounds(442, 441, 97, 25);
		getContentPane().add(btnAddTask);

		/* Delete task button */
		btnDeleteTask = new JButton("Delete task");
		btnDeleteTask.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeleteTask.setForeground(Color.BLACK);
		btnDeleteTask.setBounds(63, 441, 107, 25);
		getContentPane().add(btnDeleteTask);

		btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogout.setForeground(Color.BLUE);
		btnLogout.setBounds(496, 28, 97, 25);
		getContentPane().add(btnLogout);

		btnChangePassword = new JButton("Change password");
		btnChangePassword.setForeground(Color.BLUE);
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnChangePassword.setBounds(437, 63, 156, 25);
		getContentPane().add(btnChangePassword);

		btnHistory = new JButton("History");
		btnHistory.setForeground(Color.BLACK);
		btnHistory.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnHistory.setBounds(247, 441, 107, 25);
		getContentPane().add(btnHistory);

	}

	public void addAddTaskButtonActionListener(final ActionListener actionListener) {
		btnAddTask.addActionListener(actionListener);
	}

	public void addDeleteTaskButtonActionListener(final ActionListener actionListener) {
		btnDeleteTask.addActionListener(actionListener);
	}

	public void addLogoutButtonActionListener(final ActionListener actionListener) {
		btnLogout.addActionListener(actionListener);
	}

	public void addChangePasswordButtonActionListener(final ActionListener actionListener) {
		btnChangePassword.addActionListener(actionListener);
	}

	public void addHistoryButtonActionListener(final ActionListener actionListener) {
		btnHistory.addActionListener(actionListener);
	}

	public void addTodayTasksListSelectionListener(final ListSelectionListener listSelectionListener) {
		todayTasksList.addListSelectionListener(listSelectionListener);
	}

	public void addUpcomingTasksListSelectionListener(final ListSelectionListener listSelectionListener) {
		upcomingTasksList.addListSelectionListener(listSelectionListener);
	}

	public String[] getTodayTasksList() {
		String[] outputArray = new String[todayModel.size()];
		for (int i = 0; i < todayModel.size(); i++) {
			outputArray[i] = todayModel.get(i);
		}
		return outputArray;
	}

	public String[] getUpcomingTasksList() {
		String[] outputArray = new String[upcomingModel.size()];
		for (int i = 0; i < upcomingModel.size(); i++) {
			outputArray[i] = upcomingModel.get(i);
		}
		return outputArray;
	}

	public int getTodayTasksSelectedIndex() {
		if (!todayTasksList.isSelectionEmpty()) {
			return todayTasksList.getSelectedIndex();
		}
		return -1;
	}

	public int getUpcomingTasksSelectedIndex() {
		if (!upcomingTasksList.isSelectionEmpty()) {
			return upcomingTasksList.getSelectedIndex();
		}
		return -1;
	}

	public String getTodayTask(int index) {
		return todayModel.getElementAt(index);
	}

	public String getUpcomingTask(int index) {
		return upcomingModel.getElementAt(index);
	}

	public void addUpcomingTask(String description) {
		upcomingModel.addElement(description);
	}

	public void addTodayTask(String description) {
		todayModel.addElement(description);
	}

	public void removeTaskTodayList(int index) {
		todayModel.remove(index);
	}

	public void removeTaskUpcomingList(int index) {
		upcomingModel.remove(index);
	}

	public void setWelcomeLabel(final String welcomeLabel) {
		lblWelcomeFirstName.setText("Welcome, " + welcomeLabel + "!");
	}

	public void setTodayModel(String[] todayData) {
		for (int i = 0; i < todayData.length; i++) {
			if (todayData[i] != null) {
				todayModel.addElement(todayData[i]);
			}
		}
	}

	public void setUpcomingModel(String[] upcomingData) {
		for (int i = 0; i < upcomingData.length; i++) {
			if (upcomingData[i] != null) {
				upcomingModel.addElement(upcomingData[i]);
			}
		}
	}

	public void resetSelectedIndexTodayList() {
		todayTasksList.clearSelection();
	}

	public void resetSelectedIndexUpcomingList() {
		upcomingTasksList.clearSelection();
	}

	public boolean isTodayListSelectionEmpty() {
		return todayTasksList.isSelectionEmpty();
	}

	public boolean isUpcomingListSelectionEmpty() {
		return upcomingTasksList.isSelectionEmpty();
	}

	public void clearTaskLists() {
		todayModel.clear();
		upcomingModel.clear();
	}
}