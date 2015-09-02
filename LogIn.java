import java.awt.EventQueue;
//import javax.swing.JFrame;
import java.sql.*;
import java.awt.Image;
import javax.swing.*;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn {
	Connection conn = null;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JTextField textField_1;
	private JTextField textField_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn window = new LogIn();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public LogIn() {
		initialize();
		conn = SqliteConnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 100, 0));
		frame.setBounds(100, 100, 1235, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Username = new JLabel("Username:");
		Username.setForeground(new Color(255, 255, 255));
		Username.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 30));
		Username.setBounds(431, 356, 151, 39);
		frame.getContentPane().add(Username);
		
		JLabel  lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(441, 397, 136, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(577, 366, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(577, 408, 116, 22);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String UN = textField.getText();
					String PW = passwordField.getText();
					
					if(UN.equals("OPA")&& PW.equals("OPA")){
						JOptionPane.showMessageDialog(null,"Correct");
						frame.dispose();
						Home hf = new Home();
						hf.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Incorrect Username or Password");
					
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2);

				}
			}
		});
		btnNewButton.setBounds(534, 480, 97, 25);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/OPA.jpeg")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(405, 119, 401, 223);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(75, 247, 56, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 119, 1274, 223);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(0, 480, 1217, 25);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
