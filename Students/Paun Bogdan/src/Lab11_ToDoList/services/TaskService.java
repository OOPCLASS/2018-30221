package services;

import java.util.List;
import java.util.stream.Collectors;

import model.Task;
import repository.MySQLTaskRepository;
import repository.TaskRepository;
import repository.InMemTaskRepository;

public class TaskService {

	private TaskRepository taskRepository;

	public TaskService(String repoType) {
		if (repoType.equals("InMem")) {
			taskRepository = new InMemTaskRepository();
		} else if (repoType.equals("MySQL")) {
			taskRepository = new MySQLTaskRepository();
		}
	}

	public List<Task> getAll() {
		return taskRepository.getAll();
	}

	public List<Task> getByUserUsername(final String userUsername) {
		return taskRepository.getAll().stream().filter(element -> element.getUserUsername().equals(userUsername))
				.collect(Collectors.toList());
	}

	public Task get(final int id) {
		return taskRepository.get(id);
	}

	public void create(final Task task) {
		final int id = task.getId();
		taskRepository.put(id, task);
	}

	public void update(final Task task) {
		final int id = task.getId();
		taskRepository.update(id, task);
	}

	public void remove(final int id) {
		taskRepository.remove(id);
	}

	public void removeByDescription(final String description) {
		taskRepository.removeByDescription(description);
	}

	public int size() {
		return taskRepository.size();
	}

	public int lastInsertedIndex() {
		return taskRepository.lastInsertedIndex();
	}
}
