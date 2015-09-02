import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;


public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClickHereTo = new JLabel("Click here to search the building database");
		lblClickHereTo.setForeground(new Color(255, 255, 255));
		lblClickHereTo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 28));
		lblClickHereTo.setBounds(26, 27, 749, 62);
		contentPane.add(lblClickHereTo);
		
		JLabel lblClickHereTo_1 = new JLabel("Click here to edit the building database");
		lblClickHereTo_1.setForeground(new Color(255, 255, 255));
		lblClickHereTo_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 28));
		lblClickHereTo_1.setBounds(26, 257, 707, 33);
		contentPane.add(lblClickHereTo_1);
		
		JButton search = new JButton("Search");
		search.setBounds(324, 82, 97, 25);
		contentPane.add(search);
		
		JButton edit = new JButton("Edit");
		edit.setBounds(324, 301, 97, 25);
		contentPane.add(edit);
		
		
		
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					BuildingSearch bs = new BuildingSearch();
					bs.setVisible(true);
				}
				catch(Exception e2)
				{
					JOptionPane.showMessageDialog(null,e2);

				}
			}
		});
		
		
		
	}
}
