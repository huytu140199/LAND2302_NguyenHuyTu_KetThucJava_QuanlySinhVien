package project_java;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class View_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtlogin_username;
	private JTextField txtlogin_password;
	private View_home vh;

	/**
	 * Create the frame.
	 */
	public View_login() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 605, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(239, 11, 139, 32);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("T\u00E0i kho\u1EA3n :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 63, 108, 32);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("M\u1EADt kh\u1EA9u :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 115, 108, 32);
		contentPane.add(lblNewLabel_1_1);

		txtlogin_username = new JTextField();
		txtlogin_username.setBounds(123, 71, 290, 20);
		contentPane.add(txtlogin_username);
		txtlogin_username.setColumns(10);

		txtlogin_password = new JTextField();
		txtlogin_password.setColumns(10);
		txtlogin_password.setBounds(123, 123, 290, 20);
		contentPane.add(txtlogin_password);

		JButton btnNewButton = new JButton("\u0110\u0103ng nh\u1EADp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account user = new account();
				user.setUsername(txtlogin_username.getText().trim());
				user.setPassword(txtlogin_password.getText().trim());
				if (user.checkUser(user)) {

					vh = new View_home();
					vh.setVisible(true);
					dispose();
				} else {
					JOptionPane.showMessageDialog(btnNewButton, "Tai khoan hoac mat khau khong dung");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(239, 236, 139, 32);
		contentPane.add(btnNewButton);
	}
}
