package repository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Task;

public class InMemTaskRepository extends TaskRepository {

	private Map<Integer, Task> tasks = new HashMap<Integer, Task>();

	public InMemTaskRepository() {
		String[] adminTodayList = { "Lorem", "ipsum", "dolor", "sit", "amet" };
		String[] adminUpcomingList = { "Nam", "in", "ante" };

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Calendar date = Calendar.getInstance();
		String currentDate = dateFormat.format(date.getTime());
		date.add(Calendar.DATE, 5);
		String upcomingDate = dateFormat.format(date.getTime());

		int index = 0;

		for (int i = 0; i < adminTodayList.length; i++) {
			Task task = new Task();
			task.setId(index++);
			task.setDescription(adminTodayList[i]);
			task.setUserUsername("admin");
			task.setDueDate(currentDate);
			put(index, task);
		}

		for (int i = 0; i < adminUpcomingList.length; i++) {
			Task task = new Task();
			task.setId(index++);
			task.setDescription(adminUpcomingList[i]);
			task.setUserUsername("admin");
			task.setDueDate(upcomingDate);
			put(index, task);
		}
	}

	@Override
	public List<Task> getAll() {
		return tasks.values().stream().map(element -> element).collect(Collectors.toList());
	}

	@Override
	public Task get(int id) {
		return tasks.get(id);
	}

	@Override
	public void put(int id, Task task) {
		tasks.put(id, task);
	}

	@Override
	public void update(int id, Task task) {
		tasks.put(id, task);
	}

	@Override
	public void remove(int id) {
		tasks.remove(id);
	}

	@Override
	public void removeByDescription(String description) {
		tasks.values().removeIf(v -> v.getDescription().equals(description));
	}

	@Override
	public int size() {
		return tasks.size();
	}

	@Override
	public int lastInsertedIndex() {
		return tasks.entrySet().stream()
				.reduce((curr, next) -> (curr.getValue().getId() > next.getValue().getId() ? curr : next)).get()
				.getValue().getId();

	}
}
