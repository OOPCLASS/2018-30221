package services;

import java.util.List;

import model.User;
import repository.MySQLUserRepository;
import repository.UserRepository;
import repository.InMemUserRepository;

public class UserService {

	private UserRepository userRepository;
	
	public UserService(String repoType) {
		if(repoType.equals("InMem")) {
			userRepository = new InMemUserRepository();
		}else if(repoType.equals("MySQL")) {
			userRepository = new MySQLUserRepository();
		}
	}
	
	public List<User> getAll() {
		return userRepository.getAll();
	}

	public User get(final String username) {
		return userRepository.get(username);
	}

	public void create(final User user) {
		String username = user.getUsername();
		if (username != null) {
			userRepository.put(username, user);
		}
	}

	public void update(final User user) {
		String username = user.getUsername();
		if (username != null) {
			userRepository.update(username, user);
		}
	}

	public void remove(final String username) {
		userRepository.remove(username);
	}

	public int size() {
		return userRepository.size();
	}
	
	public int lastInsertedIndex() {
		return userRepository.lastInsertedIndex();
	}

}
