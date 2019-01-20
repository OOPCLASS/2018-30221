package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class MySQLUserRepository extends UserRepository{

	private String url = "jdbc:mysql://localhost/todolist";
	private String uid = "root";
	private String pw = "";
	private Connection con;

	@Override
	public List<User> getAll() {
		init();
		String sqlSt = "SELECT * FROM users;";
		List<User> outputList = selectUsers(sqlSt);
		closeConnection();
		
		if(!outputList.isEmpty()) {
			return outputList;
		}
		
		return null;
	}

	@Override
	public User get(final String username) {
		init();
		String sqlSt = "SELECT * FROM users WHERE users.username = '" + username + "' ORDER BY users.id ASC;";
		List<User> outputList = selectUsers(sqlSt);
		closeConnection();
		
		if(!outputList.isEmpty()) {
			return outputList.iterator().next();
		}
		
		return null;
	}

	@Override
	public void put(final String username, final User user) {
		init();
		String sqlSt = "INSERT INTO users(id, firstname, lastname, username, password)" + "VALUES(" + user.getId()
				+ ", '" + user.getFirstName() + "', '" + user.getLastName() + "', '" + user.getUsername() + "', '"
				+ user.getPassword() + "');";
		alterUsers(sqlSt);
		closeConnection();
	}

	@Override
	public void update(final String username, final User user) {
		init();
		String sqlSt = "UPDATE users SET users.password = '" + user.getPassword() + "' WHERE users.username = '"
				+ username + "';";
		alterUsers(sqlSt);
		closeConnection();
	}

	@Override
	public void remove(final String username) {
		init();
		String sqlSt = "DELETE FROM tasks WHERE tasks.userUsername = '" + username + "';"
				+ "DELETE FROM users WHERE users.username = '" + username + "';";
		alterUsers(sqlSt);
		closeConnection();
	}

	@Override
	public int size() {
		init();
		String sqlSt = "SELECT COUNT(users.id) FROM users;";
		int size = 0;

		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(sqlSt);

			rst.next();
			size = rst.getInt(1);

			rst.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}

		closeConnection();

		return size;
	}
	
	@Override
	public int lastInsertedIndex() {
		init();
		String sqlSt = "SELECT users.id FROM users ORDER BY users.id DESC LIMIT 1;";
		int index = 0;

		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(sqlSt);

			rst.next();
			index = rst.getInt(1);

			rst.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}

		closeConnection();

		return index;
	}

	private void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.println("ClassNotFoundException: " + e);
		}
		con = null;
		try {
			con = DriverManager.getConnection(url, uid, pw);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
			System.exit(1);
		}
	}

	private void closeConnection() {
		try {
			con.close();
		} catch (SQLException ex) {
			System.err.println("Exception during connection close: " + ex);
		}
	}

	private void alterUsers(String queryString) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(queryString);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
	}

	private List<User> selectUsers(String queryString) {

		List<User> outputList = new ArrayList<User>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(queryString);

			while (rst.next()) {
				User newUser = new User();

				newUser.setId(rst.getInt(1));
				newUser.setFirstName(rst.getString(2));
				newUser.setLastName(rst.getString(3));
				newUser.setUsername(rst.getString(4));
				newUser.setPassword(rst.getString(5));

				outputList.add(newUser);
			}

			rst.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}

		return outputList;
	}

	public void getAllUsers() {
		init();
		printQueryResult("SELECT * FROM users");
		closeConnection();
	}

	private void printQueryResult(String queryStr) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(queryStr);
			ResultSetMetaData rsmd = rst.getMetaData();

			// Calculate column sizes (cut off large columns to 35)
			int colCount = rsmd.getColumnCount();
			int rowCount = 0;
			int colWidth[] = new int[colCount];
			for (int i = 1; i <= colCount; i++) {
				colWidth[i - 1] = rsmd.getColumnDisplaySize(i);
				if (colWidth[i - 1] > 35) {
					colWidth[i - 1] = 35;
				}
			}

			System.out.println();
			// Print header
			for (int i = 1; i <= colCount; i++) {
				String colName = rsmd.getColumnName(i);
				System.out.print(colName + spaces(colWidth[i - 1] - colName.length()) + ' ');
			}
			System.out.println("\n-----------------------------------------------------------------------");

			while (rst.next()) {
				for (int i = 1; i <= colCount; i++) {
					Object obj = rst.getObject(i);
					if (obj == null)
						System.out.print(spaces(colWidth[i - 1]));
					else {
						String data = obj.toString();
						System.out.print(data + spaces(colWidth[i - 1] - data.length()) + ' ');
					}
				}
				System.out.println();
				rowCount++;
			}
			if (rowCount == 0) {
				System.out.println("No results.");
			}
			rst.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
	}

	private static String spaces(int space) {
		String sp = "";
		for (int i = 0; i < space; i++)
			sp = sp + " ";
		return sp;
	}
}
