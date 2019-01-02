package model;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;

	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		StringBuilder stringBuilder = new StringBuilder("Id = ");
		return stringBuilder.append(id).append(", FirstName = ").append(firstName).append(", LastName = ")
				.append(lastName).append(", UserName = ").append(username).append(", Password = ").append(password)
				.toString();
	}
}
