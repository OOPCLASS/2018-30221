package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.User;

public class InMemUserRepository extends UserRepository {

	private Map<String, User> users = new HashMap<String, User>();

	public InMemUserRepository() {
		User user = new User();

		user.setId(0);
		user.setFirstName("Administrator");
		user.setLastName("Admin");
		user.setPassword("admin");
		user.setUsername("admin");
		users.put(user.getUsername(), user);
	}

	@Override
	public List<User> getAll() {
		return users.values().stream().map(element -> element).collect(Collectors.toList());
	}

	@Override
	public User get(final String username) {
		return users.get(username);
	}

	@Override
	public void put(final String username, final User user) {
		users.put(username, user);
	}

	@Override
	public void update(final String username, final User user) {
		users.put(username, user);
	}

	@Override
	public void remove(final String username) {
		users.remove(username);
	}

	@Override
	public int size() {
		return users.size();
	}

	@Override
	public int lastInsertedIndex() {
		return users.entrySet().stream()
				.reduce((curr, next) -> (curr.getValue().getId() > next.getValue().getId() ? curr : next)).get()
				.getValue().getId();

	}
}
