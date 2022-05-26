package examRegistration;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;


import java.sql.*;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
public class reg11 {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtpassword;
	JComboBox txtyear;

	public reg11() {
		initialize();
		connect();
	}
	Connection con;
	PreparedStatement pst;
	public void connect() {
		try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");			
		} catch (Exception e) { 			
			 e.printStackTrace();
		}		
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 472, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(69, 27, 312, 24);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME(username) :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(12, 100, 168, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(12, 161, 168, 16);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("YEAR :");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(12, 222, 168, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		txtname = new JTextField();
		txtname.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		txtname.setBounds(185, 98, 236, 22);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtpassword = new JTextField();
		txtpassword.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		txtpassword.setBounds(185, 159, 236, 22);
		frame.getContentPane().add(txtpassword);
		txtpassword.setColumns(10);
		
		txtyear = new JComboBox<String>();
		txtyear.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		txtyear.addItem("1");
		txtyear.addItem("2");
		txtyear.addItem("3");
		//txtyear.addItem("4");
		txtyear.setSelectedItem(null);
		txtyear.setBounds(185, 219, 236, 24);
		frame.getContentPane().add(txtyear);
		txtyear.setSelectedItem(null);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name,password,year,usertype;

				name = txtname.getText();
				password = txtpassword.getText();
				usertype = "0" ;
				year =  (String) txtyear.getSelectedItem();
				
				if(year == null || name.equals("") || password.equals("")) {
					JOptionPane.showMessageDialog(null,"Insert the data...!!","Register Failed",2);
				}
				else {
					try {
						pst = con.prepareStatement("INSERT INTO `users`( `userName`, `password`, `usertype`, `stdYear`) VALUES (?,?,?,?)"); 
						
						pst.setString(1, name);
						pst.setString(2, password);
						pst.setString(3,usertype);
						pst.setString(4, year);
						pst.executeUpdate();
						
						txtname.setText("");
						txtpassword.setText("");
						txtyear.getSelectedItem();
						txtname.requestFocus();		
					} 
					catch (Exception e1){
						 e1.printStackTrace();	
					}
				JOptionPane.showMessageDialog(frame,"Succefully Registered....");
				frame.dispose();
				UserLogin re = new UserLogin();
				}
				
				
			}
		});
		
		
		
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		btnNewButton.setBounds(22, 307, 191, 72);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClose = new JButton("CLOSE");
		btnClose.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource()== btnClose) {
					UserLogin re = new UserLogin();
					frame.dispose();
				}
				
			}
		});
		btnClose.setFont(new Font("Arial", Font.BOLD, 18));
		btnClose.setBounds(241, 307, 191, 72);
		frame.getContentPane().add(btnClose);
		frame.setVisible(true);
	}
}
