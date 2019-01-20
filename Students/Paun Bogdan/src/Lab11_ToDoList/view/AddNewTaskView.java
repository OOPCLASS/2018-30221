package view;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class AddNewTaskView extends JFrame {
	
	private static final long serialVersionUID = -7596087649853041779L;
	
	private JTextField descriptionTextField;
	private JTextField dateTextField;
	private JButton btnPick;
	private JButton btnCancel;
	private JButton btnSave;
	private JLabel messageLabel;
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private final static int windowWidth = 411;
	private final static int windowHeight = 328;

	public AddNewTaskView(int widthOrigin, int heightOrigin) {
		this.setResizable(false);
		
		this.setTitle("Add a new task");
		this.setBounds(widthOrigin/2 - windowWidth/2, heightOrigin/2 - windowHeight/2, windowWidth, windowHeight);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setBounds(89, 38, 225, 26);
		getContentPane().add(descriptionTextField);
		descriptionTextField.setColumns(10);

		dateTextField = new JTextField();
		dateTextField.setText(dateFormat.format(new Date()));
		dateTextField.setBounds(89, 122, 116, 26);
		getContentPane().add(dateTextField);
		dateTextField.setColumns(10);

		btnPick = new JButton("Pick");
		btnPick.setForeground(Color.BLACK);
		btnPick.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPick.setBounds(217, 122, 97, 25);
		getContentPane().add(btnPick);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDescription.setBounds(89, 13, 77, 25);
		getContentPane().add(lblDescription);

		JLabel lblDueDate = new JLabel("Due date");
		lblDueDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDueDate.setBounds(89, 93, 67, 25);
		getContentPane().add(lblDueDate);

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(89, 241, 97, 25);
		getContentPane().add(btnCancel);

		btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(217, 241, 97, 25);
		getContentPane().add(btnSave);
		
		messageLabel = new JLabel("Error message");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(89, 181, 225, 25);
		getContentPane().add(messageLabel);
		messageLabel.setVisible(false);
		
	}
		
	public void addPickButtonEventListener(final ActionListener actionListener) {
		btnPick.addActionListener(actionListener);
	}
	
	public void addSaveButtonEventListener(final ActionListener actionListener) {
		btnSave.addActionListener(actionListener);
	}
	
	public void addCancelButtonEventListener(final ActionListener actionListener) {
		btnCancel.addActionListener(actionListener);
	}

	public void setDateTextField(String setPickedDate) {
		dateTextField.setText(setPickedDate);
	}

	public String getDescription() {
		return descriptionTextField.getText();
	}

	public String getDueDate() {
		return dateTextField.getText();
	}

	public void resetTextFields() {
		descriptionTextField.setText("");
		dateTextField.setText(dateFormat.format(new Date()));
	}
	
	public void displayMessage(String messageText) {
		final Runnable runnable = new Runnable() {

			@Override
			public void run() {
				messageLabel.setText(messageText);
				messageLabel.setVisible(true);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					messageLabel.setVisible(false);
				}
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}