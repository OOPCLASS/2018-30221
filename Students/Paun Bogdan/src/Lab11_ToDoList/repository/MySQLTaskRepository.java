package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class MySQLTaskRepository extends TaskRepository {

	private String url = "jdbc:mysql://localhost/todolist";
	private String uid = "root";
	private String pw = "";
	private Connection con;

	@Override
	public List<Task> getAll() {
		init();
		String sqlSt = "SELECT * FROM tasks ORDER BY tasks.userUsername, tasks.dueDate ASC;";
		List<Task> outputList = selectTasks(sqlSt);
		closeConnection();

		if (!outputList.isEmpty()) {
			return outputList;
		}

		return null;
	}

	@Override
	public Task get(final int id) {
		init();
		String sqlSt = "SELECT * FROM tasks WHERE tasks.id = " + id + ";";
		List<Task> outputList = selectTasks(sqlSt);
		closeConnection();

		if (!outputList.isEmpty()) {
			return outputList.iterator().next();
		}

		return null;
	}

	@Override
	public void put(final int id, final Task task) {
		init();
		String sqlSt = "INSERT INTO tasks(id, userUsername, description, dueDate)" + "VALUES(" + id + ", '"
				+ task.getUserUsername() + "', '" + task.getDescription() + "', '" + task.getDueDate() + "');";
		alterTasks(sqlSt);
		closeConnection();
	}

	@Override
	public void update(final int id, final Task task) {
		init();
		String sqlSt = "UPDATE tasks SET tasks.description = '" + task.getDescription() + "' WHERE tasks.id = " + id
				+ ";";
		alterTasks(sqlSt);
		closeConnection();
	}

	@Override
	public void remove(final int id) {
		init();
		String sqlSt = "DELETE FROM tasks WHERE tasks.id =" + id + ";";
		alterTasks(sqlSt);
		closeConnection();
	}

	@Override
	public void removeByDescription(final String description) {
		init();
		String sqlSt = "DELETE FROM tasks WHERE tasks.description = '" + description + "';";
		alterTasks(sqlSt);
		closeConnection();
	}

	@Override
	public int size() {
		init();
		String sqlSt = "SELECT COUNT(tasks.id) FROM tasks;";
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
		String sqlSt = "SELECT tasks.id FROM tasks ORDER BY tasks.id DESC LIMIT 1;";
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

	private void alterTasks(String queryString) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(queryString);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}
	}

	private List<Task> selectTasks(String queryString) {

		List<Task> outputList = new ArrayList<Task>();

		try {
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery(queryString);

			while (rst.next()) {
				Task newTask = new Task();

				newTask.setId(rst.getInt(1));
				newTask.setUserUsername(rst.getString(2));
				newTask.setDescription(rst.getString(3));
				newTask.setDueDate(rst.getString(4));

				outputList.add(newTask);
			}

			rst.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex);
		}

		return outputList;
	}

	public void getAllTasks() {
		init();
		printQueryResult("SELECT * FROM tasks");
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
