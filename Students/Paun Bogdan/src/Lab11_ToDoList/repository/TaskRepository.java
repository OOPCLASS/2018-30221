package repository;

import java.util.List;

import model.Task;

public abstract class TaskRepository {
	public abstract List<Task> getAll();
	
	public abstract Task get(final int id);
	
	public abstract void put(final int id, final Task task);

	public abstract void update(final int id, final Task task);

	public abstract void remove(final int id);
	
	public abstract void removeByDescription(final String description);
	
	public abstract int size();
	
	public abstract int lastInsertedIndex();
}
