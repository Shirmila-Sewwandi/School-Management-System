package examRegistration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class Register extends JFrame implements ActionListener {

	JComboBox comboBox;
	JButton logOut;
	JButton addButton;
	JTextArea textArea;
	String courseID;
	JLabel indexNum;
	JButton printButton;
	JScrollPane scrollPane;
	JButton submitButton;
	HashMap<Integer,String> course = new HashMap<Integer,String>();
	JLabel lblNewLabel = new JLabel("Register");
	int i=0;
	private JSeparator separator_1;
	private JLabel lblNewLabel_1;
	private JLabel yearNum;
	private JLabel lblNewLabel_3;
	public  Register() {
		getContentPane().setBackground(Color.WHITE);
		
		this.setVisible(true);
		getContentPane().setLayout(null);
		
		//SqlConnection sql = new SqlConnection();
		
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(138, 50, 175, 59);
		getContentPane().add(lblNewLabel);
		
		submitButton = new JButton("Submit");
		submitButton.setFont(new Font("Arial", Font.BOLD, 18));
		submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		submitButton.addActionListener(this);
		submitButton.setBounds(213, 383, 100, 50);
		getContentPane().add(submitButton);
		
		addButton = new JButton("ADD");
		addButton.setFont(new Font("Arial", Font.BOLD, 18));
		addButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		addButton.setBounds(46, 383, 100, 50);
		addButton.addActionListener(this);
		getContentPane().add(addButton);
		
		comboBox = new JComboBox();
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		comboBox.setBounds(21, 184, 303, 35);
		getContentPane().add(comboBox);
		
		logOut = new JButton("Log Out");
		logOut.setFont(new Font("Arial", Font.BOLD, 18));
		logOut.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		logOut.setBounds(537, 383, 100, 50);
		logOut.addActionListener(this);
		getContentPane().add(logOut);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 103, 303, 35);
		getContentPane().add(separator);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		textArea.setEditable(false);
		textArea.setBounds(352, 18, 285, 346);
		getContentPane().add(textArea);
		
		indexNum = new JLabel("s1400");
		indexNum.setFont(new Font("Tahoma", Font.BOLD, 25));
		indexNum.setBounds(136, 18, 177, 45);
		getContentPane().add(indexNum);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(334, 23, 55, 341);
		getContentPane().add(separator_1);
		
		lblNewLabel_1 = new JLabel("Courses");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 143, 100, 30);
		getContentPane().add(lblNewLabel_1);
		
//		String year[]= {"1","2","3","4"};
		
		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(10, 267, 70, 22);
		getContentPane().add(lblNewLabel_2);
		
		yearNum = new JLabel("New label");
		yearNum.setFont(new Font("Arial", Font.BOLD, 20));
		yearNum.setBounds(90, 268, 106, 20);
		getContentPane().add(yearNum);
		
		printButton = new JButton("Print ");
		printButton.setFont(new Font("Arial", Font.BOLD, 18));
		printButton.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		printButton.setBounds(376, 383, 100, 50);
		printButton.addActionListener(this);
		getContentPane().add(printButton);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("user2.png"));
		lblNewLabel_3.setBounds(46, 16, 101, 76);
		getContentPane().add(lblNewLabel_3);
		
		
		this.setBounds(100, 100, 682, 483);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void showData(String name,String num) {
		lblNewLabel.setText(name);
		indexNum.setText(num);
		textArea.append("\t Course Registration\n");
		textArea.append("-------------------------------------------------------------------------\n");
		textArea.append("Index Number: "+num+"\n");
		comboBox.setSelectedItem(null);
//		comboBox.addItem(courseID);	
		
//		String number = indexNum.getText();

	}
	public void courseData(String courseID) {
		comboBox.setSelectedItem(null);
		comboBox.addItem(courseID);
	}
	
	public void showData(String year) {
		yearNum.setText(year);
		textArea.append("Year: "+year+"\n");
		textArea.append("-------------------------------------------------------------------------\n");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==logOut) {
			UserLogin re = new UserLogin();
			this.dispose();
		}
		
		if(e.getSource()==addButton) {
			i++;
			textArea.append("\n"+(String) comboBox.getSelectedItem());
			course.put(i, (String) comboBox.getSelectedItem());
			comboBox.removeItem(comboBox.getSelectedItem());
//			comboBox.setSelectedItem(null);
		}
		
		if(e.getSource()==submitButton) {
			ResultSet rs;
			String idNumber = indexNum.getText();
			String year = yearNum.getText();
			String name = lblNewLabel.getText();
			//String course = textArea.getSelectedText();
			
			SqlConnection sql = new SqlConnection();
			rs = sql.InsertData(idNumber,year,name,course.get(1),course.get(2),course.get(3),course.get(4),course.get(5));
			
			JOptionPane.showMessageDialog(null,"Saved !!");
			addButton.setEnabled(false);
			submitButton.setEnabled(false);
		}
		
		
		
		if(e.getSource() == printButton) {
			try {
				textArea.print();
			} catch (PrinterException e1) {
				e1.printStackTrace();
			}
			printButton.setEnabled(false);
		}
		
	}
}
