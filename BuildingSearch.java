import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class BuildingSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Connection c;
	private JTable table;

	/**
	 * Launch the application.
	 */
	
	//Method which connects application to database
	public Connection dbConnector()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\rlpla_000\\Downloads\\sqlite-shell-win32-x86-3080704\\OPA.db");
			return c;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
	}
	//run frame
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingSearch frame = new BuildingSearch();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame. Adding buttons,text fields etc.
	 */
	public BuildingSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 498);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton search = new JButton("Search");
		search.setBackground(new Color(255, 255, 255));
		search.setBounds(67, 61, 97, 25);
		contentPane.add(search);
		
		textField = new JTextField();
		textField.setBounds(176, 62, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterBuildingAddress = new JLabel("Enter Building Address");
		lblEnterBuildingAddress.setForeground(Color.WHITE);
		lblEnterBuildingAddress.setFont(new Font("Sitka Small", Font.BOLD, 32));
		lblEnterBuildingAddress.setBounds(38, 13, 476, 40);
		contentPane.add(lblEnterBuildingAddress);
		
		
		
	
//Search action event method on button press		
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbConnector();
				try{
					String address = textField.getText();
					address = address.replaceAll("\\p{Z}","");
			
		
					Statement stmt = c.createStatement();
					ResultSet building = stmt.executeQuery("SELECT * FROM _" + address + ";");
		
					int vacApt = building.getInt("vacantApt");
					System.out.print(vacApt);
			
					int aptNum = building.getInt("aptNum");
					System.out.print(aptNum);
			
					int tenants = building.getInt("tenants");
					System.out.print(tenants);
			
					JTextArea textArea = new JTextArea();
					textArea.setBounds(135, 143, 461, 170);
					contentPane.add(textArea);
					textArea.append("Vacant Apartments: " + vacApt + "\n"
							+ "Apartment Number: " + aptNum + "\n"
							+ "Tenants: " + tenants);	
				}
				catch(Exception x){
					JOptionPane.showMessageDialog(null,x);
				}
			}
		});	
	}
}
