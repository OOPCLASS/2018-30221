package model;

public class Task {
	private int id;
	private String userUsername;
	private String description;
	private String dueDate;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserUsername() {
		return this.userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder("Id = ");
		return stringBuilder.append(id).append(", userUsername = ").append(userUsername).append(", Description = ")
				.append(description).append(", Due date = ").append(dueDate).toString();
	}
}
