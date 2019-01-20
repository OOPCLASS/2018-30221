package view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HistoryView extends JFrame {

	private static final long serialVersionUID = -5608034460549953600L;

	private final static int windowWidth = 300;
	private final static int windowHeight = 350;
	private final static String[] columnNames = { "Description", "DueDate" };

	private JTable table;
	private DefaultTableModel tableModel;

	public HistoryView(int widthOrigin, int heightOrigin) {
		this.setTitle("History");
		this.setResizable(false);

		this.setBounds(widthOrigin / 2 - windowWidth / 2, heightOrigin / 2 - windowHeight / 2, 435, 469);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		table = new JTable();
		table.setShowHorizontalLines(false);
		table.setBorder(new LineBorder(new Color(0, 0, 1)));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(66, 81, 300, 312);
		getContentPane().add(tableScrollPane);

		JLabel lblHistory = new JLabel("History");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHistory.setBounds(144, 35, 150, 33);
		getContentPane().add(lblHistory);
	}

	public void setTableModel(String[][] data) {
		tableModel = new DefaultTableModel(data, columnNames) {
			private static final long serialVersionUID = -8179472104615666673L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(tableModel);
	}
}
