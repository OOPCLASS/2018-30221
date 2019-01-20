package repository;

import java.util.List;

import model.User;

public abstract class UserRepository {

	public abstract List<User> getAll();

	public abstract User get(final String username);

	public abstract void put(final String username, final User user);

	public abstract void update(final String username, final User user);

	public abstract void remove(final String username);

	public abstract int size();

	public abstract int lastInsertedIndex();

}
