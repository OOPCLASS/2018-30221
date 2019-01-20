package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class ChangePasswordView extends JFrame {

	private static final long serialVersionUID = 5667802550564440899L;
	
	private JButton submitButton;
	private JLabel messageLabel;
	private JPasswordField currentPasswordTextField;
	private JPasswordField newPasswordTextField;
	
	private final static int windowWidth = 350;
	private final static int windowHeight = 300;

	public ChangePasswordView(int widthOrigin, int heightOrigin) {
		
		this.setTitle("Change password");
		this.setResizable(false);
		
		this.setBounds(widthOrigin/2 - windowWidth/2, heightOrigin/2 - windowHeight/2, windowWidth, windowHeight);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel currentPasswordLabel = new JLabel("Current password");
		currentPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		currentPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentPasswordLabel.setBounds(112, 44, 117, 14);
		getContentPane().add(currentPasswordLabel);
		
		JLabel newPasswordLabel = new JLabel("New password");
		newPasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		newPasswordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		newPasswordLabel.setBounds(124, 104, 94, 14);
		getContentPane().add(newPasswordLabel);
		
		currentPasswordTextField = new JPasswordField();
		currentPasswordTextField.setEchoChar('*');
		currentPasswordTextField.setBounds(86, 65, 162, 26);
		getContentPane().add(currentPasswordTextField);

		newPasswordTextField = new JPasswordField();
		newPasswordTextField.setEchoChar('*');
		newPasswordTextField.setBounds(86, 125, 162, 26);
		getContentPane().add(newPasswordTextField);

		submitButton = new JButton("Submit");
		submitButton.setForeground(Color.BLACK);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		submitButton.setBounds(129, 175, 79, 23);
		getContentPane().add(submitButton);
		
		messageLabel = new JLabel("Error message");
		messageLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		messageLabel.setForeground(Color.RED);
		messageLabel.setBounds(12, 236, 309, 16);
		getContentPane().add(messageLabel);
		messageLabel.setVisible(false);
	}
	
	public void addSubmitButtonActionListener(final ActionListener actionListener) {
		submitButton.addActionListener(actionListener);
	}

	public String getCurrentPassword() {
		return String.valueOf(currentPasswordTextField.getPassword());
	}
	
	public void setCurrentPassword(final String currentPassword) {
		this.currentPasswordTextField.setText(currentPassword);
	}
	
	public String getNewPassword() {
		return String.valueOf(newPasswordTextField.getPassword());
	}
	
	public void setNewPassword(final String newPassword) {
		this.newPasswordTextField.setText(newPassword);
	}
	
	public void clearTextFields() {
		this.setCurrentPassword(null);
		this.setNewPassword(null);
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
