package component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DatePicker {
	private int month = Calendar.getInstance().get(Calendar.MONTH);
	private int year = Calendar.getInstance().get(Calendar.YEAR);

	private JLabel label = new JLabel("", JLabel.CENTER);
	private String day = "";
	private JDialog dialog;
	private JButton[] button = new JButton[49];
	private JLabel lblLunaAnului;

	private String[] yearMonth = { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };

	public DatePicker(JFrame parent) {
		dialog = new JDialog();
		dialog.setModal(true);
		String[] header = { "Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun" };

		JPanel p0 = new JPanel(new GridLayout(1, 1));
		p0.setPreferredSize(new Dimension(430, 20));
		lblLunaAnului = new JLabel("Luna anului");
		lblLunaAnului.setForeground(Color.BLUE);
		lblLunaAnului.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunaAnului.setFont(new Font("Tahoma", Font.BOLD, 16));
		p0.add(lblLunaAnului);

		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));

		for (int x = 0; x < button.length; x++) {
			final int selection = x;

			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);

			if (x <= 6) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
				button[x].setEnabled(false);
			}

			if (x > 6) {
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						dialog.dispose();
					}
				});
			}

			p1.add(button[x]);
		}

		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (month == 0) {
					month = 11;
					year--;
				} else {
					month--;
				}
				displayDate();
			}
		});
		p2.add(previous);

		JButton next = new JButton(">");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (month == 11) {
					month = 0;
					year++;
				} else {
					month++;
				}
				displayDate();
			}
		});
		p2.add(next);

		dialog.getContentPane().add(p0, BorderLayout.NORTH);
		dialog.getContentPane().add(p1, BorderLayout.CENTER);
		dialog.getContentPane().add(p2, BorderLayout.SOUTH);
		dialog.pack();
		dialog.setLocationRelativeTo(parent);
		displayDate();
		dialog.setVisible(true);
	}

	public void displayDate() {

		for (int x = 7; x < button.length; x++) {
			button[x].setText("");
			button[x].setEnabled(false);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("MMMM yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, 1);

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		if (dayOfWeek == 1) {
			dayOfWeek = 7;
		} else {
			dayOfWeek--;
		}

		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++) {
			button[x].setText("" + day);
			button[x].setEnabled(true);
		}

		label.setText(sdf.format(cal.getTime()));
		dialog.setTitle("Date Picker");
		lblLunaAnului.setText(yearMonth[month] + " " + year);
	}

	public String setPickedDate() {
		if (day.equals(""))
			return day;

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));

		return sdf.format(cal.getTime());
	}
}