package examRegistration;

import java.sql.*;
import javax.swing.JOptionPane;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin {

	private JFrame frame;
	private JTable JtableData;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Admin window = new Admin();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	

	/**
	 * Create the application.
	 */
	public Admin() {
		
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 1204, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JButton btnLoadTable = new JButton("Load Student details");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
					
					Statement st = conn.createStatement();
					String sql = "select * from student";
					ResultSet rs = st.executeQuery(sql);
					
					while(rs.next()) {
						String No = String.valueOf(rs.getInt("No"));
						String IndexNumber = rs.getString("IndexNumber");
						String Name = rs.getString("Name");
						String Year = rs.getString("Year");
						String Course1 = rs.getString("Course1");
						String Course2 = rs.getString("Course2");
						String Course3 = rs.getString("Course3");
						
						
						String tbData [] = {No,IndexNumber,Name,Year,Course1,Course2,Course3};
						DefaultTableModel tb1Model = (DefaultTableModel)JtableData.getModel();
						
						tb1Model.addRow(tbData);
						
						
						
					}
					
					conn.close();
				}
				catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				
			}
		});
		btnLoadTable.setForeground(new Color(0, 0, 0));
		btnLoadTable.setBackground(new Color(255, 248, 220));
		btnLoadTable.setFont(new Font("Calibri", Font.ITALIC, 22));
		btnLoadTable.setBounds(523, 232, 221, 37);
		frame.getContentPane().add(btnLoadTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(231, 27, 883, 182);
		frame.getContentPane().add(scrollPane_1);
		
		JtableData = new JTable();
		scrollPane_1.setViewportView(JtableData);
		JtableData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JtableData.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		JtableData.setSurrendersFocusOnKeystroke(true);
		JtableData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "IndexNumber\t", "\tName\t", "Year\t", "Course1\t", "Course2", "Course3\t"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		JtableData.setForeground(Color.BLACK);
		JtableData.setBackground(Color.LIGHT_GRAY);
		
		JComboBox JComboYear1 = new JComboBox();
		JComboYear1.setBounds(67, 340, 231, 44);
		frame.getContentPane().add(JComboYear1);
		
		JButton btnYear1 = new JButton("Index No for Year 1");
		btnYear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
					
					Statement st2 = conn.createStatement();
					String sql2 = "SELECT `IndexNumber` FROM `student` WHERE `Year`= \"1\"";
					ResultSet rs2 = st2.executeQuery(sql2);
					
					while (rs2.next()) {
						String IndexNumber = rs2.getString("IndexNumber");
						JComboYear1.addItem(IndexNumber);
					}
					
					conn.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnYear1.setBackground(new Color(222, 184, 135));
		btnYear1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnYear1.setForeground(Color.BLACK);
		btnYear1.setBounds(67, 394, 231, 44);
		frame.getContentPane().add(btnYear1);
		
		JComboBox JComboYear2 = new JComboBox();
		JComboYear2.setBounds(513, 340, 231, 44);
		frame.getContentPane().add(JComboYear2);
		
		JButton btnYear2 = new JButton("Index No for Year 2");
		btnYear2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
					
					Statement st3 = conn.createStatement();
					String sql3 = "SELECT `IndexNumber` FROM `student` WHERE `Year`= \"2\"";
					ResultSet rs3 = st3.executeQuery(sql3);
					
					while (rs3.next()) {
						String IndexNumber = rs3.getString("IndexNumber");
						JComboYear2.addItem(IndexNumber);
					}
					
					conn.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnYear2.setForeground(Color.BLACK);
		btnYear2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnYear2.setBackground(new Color(222, 184, 135));
		btnYear2.setBounds(513, 394, 231, 44);
		frame.getContentPane().add(btnYear2);
		
		JComboBox JComboYear3 = new JComboBox();
		JComboYear3.setBounds(910, 340, 231, 44);
		frame.getContentPane().add(JComboYear3);
		
		JButton btnYear3 = new JButton("IndexNumber for Year 3");
		btnYear3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/test", "root", "");
					
					Statement st4 = conn.createStatement();
					String sql4 = "SELECT `IndexNumber` FROM `student` WHERE `Year`= \"3\"";
					ResultSet rs4 = st4.executeQuery(sql4);
					
					while (rs4.next()) {
						String IndexNumber = rs4.getString("IndexNumber");
						JComboYear3.addItem(IndexNumber);
					}
					
					conn.close();
				}
				catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnYear3.setForeground(Color.BLACK);
		btnYear3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnYear3.setBackground(new Color(222, 184, 135));
		btnYear3.setBounds(910, 394, 231, 44);
		frame.getContentPane().add(btnYear3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				JOptionPane.showMessageDialog(frame, "hey... I am Admin");
			}
		});
		lblNewLabel.setIcon(new ImageIcon("admin.jpeg"));
		lblNewLabel.setBounds(28, 27, 163, 182);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogout) {
					UserLogin re = new UserLogin();
				}
				frame.dispose();
			}
		});
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(48, 239, 101, 48);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("admin background.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1190, 468);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
	}
}
