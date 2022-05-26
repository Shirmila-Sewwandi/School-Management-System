package examRegistration;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class UserLogin extends JFrame implements ActionListener {
	private JTextField userNameField;
	private JPasswordField passwordField;
	JButton btnLogin;
	JButton registerButteon;
	JButton resetbtn;
	private JLabel lblNewLabel_2;

	public UserLogin() {
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	private void initialize() {
//		frame = new JFrame();
		this.setVisible(true);
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		userNameField = new JTextField();
		userNameField.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		userNameField.setBackground(Color.WHITE);
		userNameField.setFont(new Font("Arial", Font.PLAIN, 16));
		userNameField.setBounds(209, 153, 300, 50);
		getContentPane().add(userNameField);
		userNameField.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
		btnLogin.setBounds(35, 290, 140, 40);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener(this);
		
		registerButteon = new JButton("Register");
		registerButteon.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		registerButteon.setFont(new Font("Arial", Font.BOLD, 20));
		registerButteon.setBounds(225, 290, 140, 40);
		getContentPane().add(registerButteon);
		registerButteon.addActionListener(this);
		
		resetbtn = new JButton("Reset");
		resetbtn.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		resetbtn.setFont(new Font("Arial", Font.BOLD, 20));
		resetbtn.setBounds(419, 290, 140, 40);
		getContentPane().add(resetbtn);
		resetbtn.addActionListener(this);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 3, true));
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(209, 214, 300, 50);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setBounds(64, 163, 111, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(64, 220, 124, 37);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("un.jpeg"));
		lblNewLabel_2.setBounds(235, 11, 130, 110);
		getContentPane().add(lblNewLabel_2);

		this.setBounds(180, 150, 600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==registerButteon) {
			reg11 register = new reg11();
			this.dispose();
		}
		if(e.getSource()==resetbtn) {
			userNameField.setText("");
			passwordField.setText("");
		}
		if(e.getSource()==btnLogin) {
			String userID = userNameField.getText();
			String password = String.valueOf(passwordField.getPassword());
			if(userID.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the details!!");
			}
		else {
			String userid = userNameField.getText();
			String Password = String.valueOf(passwordField.getPassword());
			
			ResultSet rs,showcourse;
			SqlConnection sql = new SqlConnection();
			rs = sql.SaveToDataBase(userid, Password);
			showcourse = sql.ShowResult();
			try {
				if(rs.next()) {
					int usertype = rs.getInt("usertype");
					String username = rs.getString("userName");
					String studentID = rs.getString("userID");
					String year = rs.getString("stdYear");
					if(usertype == 0) {
						
							JOptionPane.showMessageDialog(null,"Welcome!!");
							Register register = new Register();
								while(showcourse.next()) {
									if(showcourse.getString("Year").equals(year)) {
									String courseID = showcourse.getString("courseID");
									String course = showcourse.getString("courseName");
									String cSum = courseID+" - "+course;
									register.courseData(cSum);
								}
							}	
							register.showData(username,"s1400"+studentID);
							register.showData(year);	
					}
					else {
						JOptionPane.showMessageDialog(null,"Wellcome!!");
						Admin adminPanel = new Admin();	
					}
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect Username Or Password","Login Failed",2);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			
		}
		
	}
}
