package test;

import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.Task;
import model.User;
import repository.MySQLTaskRepository;
import repository.MySQLUserRepository;
import repository.InMemUserRepository;
import services.UserService;

public class TestClass {

	@Test
	public void testUserRepository() {
		
		InMemUserRepository userRepo = new InMemUserRepository();
		
		Assert.assertEquals(1, userRepo.size());
		
		User firstUser = new User();
		firstUser.setFirstName("Fiiiiiirst");
		firstUser.setLastName("Laaaaast");
		firstUser.setPassword("admin");
		firstUser.setUsername("admin");
		
		System.out.println(firstUser.getStatus());
		
		userRepo.put(firstUser.getUsername(), firstUser);
		
		Assert.assertEquals(1, userRepo.size());
		
		Assert.assertEquals(firstUser, userRepo.get("admin"));
		
		List<User> usersList = userRepo.getAll();
		
		Iterator<User> listIterator = usersList.iterator();
		while(listIterator.hasNext()) {
			User user = listIterator.next();
			Assert.assertEquals(firstUser, user);
		}
		
	}
	
	@Test
	public void testUserService() {
		
		UserService userService = new UserService("InMem");
		
		User firstUser = new User();
		firstUser.setFirstName("Fiiiiiirst");
		firstUser.setLastName("Laaaaast");
		firstUser.setPassword("admin");
		firstUser.setUsername("admin");
				
		userService.create(firstUser);
		
		User user = userService.get("admin");
		
		Assert.assertEquals(firstUser, user);
	}
	
	@Test
	public void testMySQLUserRepository() {
		MySQLUserRepository userRepository = new MySQLUserRepository();
		
		userRepository.getAllUsers();
		
		List<User> usersList = userRepository.getAll();
		Iterator<User> it = usersList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getStatus());
		}
		
		System.out.println("User repository size = " + userRepository.size());
		
//		User user = new User();
//		user.setId(1);
//		user.setFirstName("Bogdan");
//		user.setLastName("Paun");
//		user.setUsername("bgdpn");
//		user.setPassword("parola");
//			
//		userRepository.put(user.getUsername(), user);
//		
//		userRepository.getAllUsers();
//		
//		user.setPassword("parolaNoua");
//		userRepository.update(user.getUsername(), user);
//		
//		userRepository.getAllUsers();
	}
	
	@Test
	public void testMySQlTaskRepository() {
		MySQLTaskRepository taskRepository = new MySQLTaskRepository();		
		
		taskRepository.getAllTasks();
		
//		taskRepository.remove(6);
		
//		System.out.println(taskRepository.get(3).getStatus());
//		
//		Task task = new Task();
//		task.setDescription("Viata e frumos");
//		task.setDueDate("29-12-2018");
//		task.setUserUsername("pcku");
//		task.setId(7);
//		taskRepository.put(task.getId(), task);
		
//		taskRepository.getAllTasks();
		
		List<Task> taskList = taskRepository.getAll();
		Iterator<Task> it = taskList.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().getStatus());
		}
		
		System.out.println("Task Repo size = " + taskRepository.size());
	}
	
}
