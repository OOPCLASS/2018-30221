package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class RegisterView extends JFrame {
	
	private static final long serialVersionUID = 1900096388246794613L;
	
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JTextField lastNameTextField;
	private JTextField firstNameTextField;
	private JLabel messageLabel;
	private JButton registerButton;
	
	private final static int windowWidth = 404;
	private final static int windowHeight = 357;

	public RegisterView(int widthOrigin, int heightOrigin) {
		this.setTitle("Register");
		this.setResizable(false);

		this.setBounds(widthOrigin/2 - windowWidth/2, heightOrigin/2 - windowHeight/2, windowWidth, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel label = new JLabel("Username");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(163, 126, 76, 14);
		getContentPane().add(label);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(119, 147, 162, 26);
		getContentPane().add(usernameTextField);

		JLabel label_1 = new JLabel("Password");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(166, 178, 68, 14);
		getContentPane().add(label_1);

		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(119, 200, 162, 26);
		getContentPane().add(passwordTextField);

		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(163, 74, 76, 14);
		getContentPane().add(lblLastName);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(119, 95, 162, 26);
		getContentPane().add(lastNameTextField);

		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(162, 22, 76, 14);
		getContentPane().add(lblFirstName);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(119, 43, 162, 26);
		getContentPane().add(firstNameTextField);

		registerButton = new JButton("Register");
		registerButton.setForeground(Color.BLACK);
		registerButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		registerButton.setBounds(157, 251, 89, 23);
		getContentPane().add(registerButton);
		
		messageLabel = new JLabel("Error message");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(119, 289, 174, 16);
		getContentPane().add(messageLabel);
		messageLabel.setVisible(false);
	}

	public void addRegisterButtonActionListener(final ActionListener e) {
		registerButton.addActionListener(e);
	}

	public void setFirstName(final String firstname) {
		this.firstNameTextField.setText(firstname);
	}

	public void setLastName(final String lastname) {
		this.lastNameTextField.setText(lastname);
	}

	public void setUsername(final String username) {
		this.usernameTextField.setText(username);
	}

	public void setPassword(final String password) {
		passwordTextField.setText(password);
	}

	public String getFirstName() {
		return firstNameTextField.getText();
	}

	public String getLastName() {
		return lastNameTextField.getText();
	}

	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return String.valueOf(passwordTextField.getPassword());
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
	
	public void clearRegisterTextFields() {
		this.setFirstName(null);
		this.setLastName(null);
		this.setUsername(null);
		this.setPassword(null);
	}

}
