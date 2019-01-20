package view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LoginView extends JFrame{

	private static final long serialVersionUID = 3168345495485349297L;
	
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	private JButton loginButton;
	private JButton notRegisteredButton;
	private JButton passwordToggleButton;
	private JLabel messageLabel;
	
	private final static int windowWidth = 350;
	private final static int windowHeight = 300;
	
	public LoginView(int widthOrigin, int heightOrigin) {
		
		this.setTitle("Login");
		this.setResizable(false);
		
		this.setBounds(widthOrigin/2 - windowWidth/2, heightOrigin/2 - windowHeight/2, windowWidth, windowHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel usernameLabel = new JLabel("username");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameLabel.setBounds(124, 33, 84, 14);
		getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("password");
		passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBounds(130, 92, 71, 14);
		getContentPane().add(passwordLabel);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(86, 53, 162, 26);
		getContentPane().add(usernameTextField);

		passwordTextField = new JPasswordField();
		passwordTextField.setEchoChar('*');
		passwordTextField.setBounds(86, 113, 162, 26);
		getContentPane().add(passwordTextField);

		loginButton = new JButton("Login");
		loginButton.setForeground(Color.BLACK);
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(129, 163, 75, 23);
		getContentPane().add(loginButton);
		
		messageLabel = new JLabel("Error message");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(12, 239, 309, 16);
		getContentPane().add(messageLabel);
		messageLabel.setVisible(false);
		
		passwordToggleButton = new JButton("?");
		passwordToggleButton.setForeground(Color.RED);
		passwordToggleButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordToggleButton.setBounds(287, 111, 39, 22);
		getContentPane().add(passwordToggleButton);

		notRegisteredButton = new JButton("Sign up");
		notRegisteredButton.setForeground(Color.BLACK);
		notRegisteredButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		notRegisteredButton.setBounds(74, 202, 188, 23);
		getContentPane().add(notRegisteredButton);
	}
	
	public void addLoginButtonActionListener(final ActionListener actionListener) {
		loginButton.addActionListener(actionListener);
	}
	
	public void addNotRegisteredButtonActionListener(final ActionListener actionListener) {
		notRegisteredButton.addActionListener(actionListener);
	}

	public void addPasswordToggleButtonMouseListener(final MouseListener mouseListener) {
		passwordToggleButton.addMouseListener(mouseListener);
	}

	public void setUsername(final String username) {
		this.usernameTextField.setText(username);
	}
	
	public void setPassword(final String password) {
		this.passwordTextField.setText(password);
	}
	
	public String getUsername() {
		return usernameTextField.getText();
	}

	public String getPassword() {
		return String.valueOf(passwordTextField.getPassword());
	}
	
	public void hidePassword() {
		passwordTextField.setEchoChar('*');
	}

	public void displayPassword() {
		passwordTextField.setEchoChar((char) 0);
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
	
	public void clearLoginTextFields() {
		this.setUsername(null);
		this.setPassword(null);
	}
	
}
