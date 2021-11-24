package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class resultentry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JComboBox comboBoxName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultentry frame = new resultentry();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void fillComboBox() {
		try
		{
	    Connection con = dbconnection.getCon();
		Statement stmnt = con.createStatement();
		ResultSet rs = stmnt.executeQuery("select * from tests");
		while(rs.next()) {
			comboBoxName.addItem(rs.getString("testtype"));
			
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	/**
	 * Create the frame.
	 */
	public resultentry() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 786, 753);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(88, 213, 149, 30);
		panel.add(lblNewLabel);
		
		JLabel lblPatientName = new JLabel("PATIENT NAME");
		lblPatientName.setForeground(Color.BLACK);
		lblPatientName.setFont(new Font("Arial", Font.BOLD, 25));
		lblPatientName.setBounds(88, 280, 201, 30);
		panel.add(lblPatientName);
		
		JLabel lblPatientId = new JLabel("TEST TYPE");
		lblPatientId.setForeground(Color.BLACK);
		lblPatientId.setFont(new Font("Arial", Font.BOLD, 25));
		lblPatientId.setBounds(88, 342, 149, 30);
		panel.add(lblPatientId);
		
		JLabel lblResultDate = new JLabel("RESULT DATE");
		lblResultDate.setForeground(Color.BLACK);
		lblResultDate.setFont(new Font("Arial", Font.BOLD, 25));
		lblResultDate.setBounds(88, 405, 187, 30);
		panel.add(lblResultDate);
		
		JLabel lblComponent = new JLabel("COMPONENT");
		lblComponent.setForeground(Color.BLACK);
		lblComponent.setFont(new Font("Arial", Font.BOLD, 25));
		lblComponent.setBounds(88, 470, 201, 30);
		panel.add(lblComponent);
		
		JLabel lblUnit = new JLabel("UNIT");
		lblUnit.setForeground(Color.BLACK);
		lblUnit.setFont(new Font("Arial", Font.BOLD, 25));
		lblUnit.setBounds(88, 538, 149, 30);
		panel.add(lblUnit);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p=textField.getText().toString();
				try
				{
				Connection con=dbconnection.getCon();
				Statement stmnt=con.createStatement();
			     ResultSet rs = stmnt.executeQuery("Select name from testentry where patientID ='"+p+"'  ");
				
				while(rs.next())
				{
					textField_1.setText(rs.getString("name"));
				}
		
				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
		});
		textField.setColumns(10);
		textField.setBounds(333, 213, 315, 40);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(333, 280, 315, 40);
		panel.add(textField_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setColumns(10);
		textField_4.setBounds(333, 470, 315, 40);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(333, 538, 315, 40);
		panel.add(textField_5);
		
		 comboBoxName = new JComboBox();
		 comboBoxName.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBoxName.setBounds(333, 341, 315, 40);
		panel.add(comboBoxName);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		dateChooser.setBounds(333, 405, 315, 44);
		panel.add(dateChooser);
		
		JButton btnadd = new JButton("ADD");
		Image img3 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnadd.setIcon(new ImageIcon (img3));
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int patientID = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String testtype = ( String)comboBoxName.getSelectedItem();
				SimpleDateFormat dft = new SimpleDateFormat("dd-MM-yyyy");
				String resultdate = dft.format(dateChooser.getDate());
				String component = textField_4.getText();
				String unit = textField_5.getText();
				
				
			
			try {
		
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				stmnt.executeUpdate("insert into resultentry values('"+patientID+"','"+name+"','"+testtype+"', '"+resultdate+"', '"+component+"','"+unit+"')");
				JOptionPane.showMessageDialog(rootPane, "Successfully added.");
				setVisible(false);
				new resultentry().setVisible(true);
				
			}
			catch(Exception ex) {
				
				JOptionPane.showMessageDialog(rootPane, "Invalid format of data. Please enter it in the correct format.");
				
			}
			}
		});
		btnadd.setFont(new Font("Arial", Font.BOLD, 25));
		btnadd.setBounds(175, 627, 177, 52);
		panel.add(btnadd);
		
		JButton btnexit = new JButton("EXIT");
		Image img4 = new ImageIcon(this.getClass().getResource("/exiticon.jpg")).getImage();
		btnexit.setIcon(new ImageIcon (img4));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnexit.setFont(new Font("Arial", Font.BOLD, 25));
		btnexit.setBounds(472, 627, 177, 52);
		panel.add(btnexit);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0,800, 800);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		
		JButton btnNewButton = new JButton("GET");
		Image img2 = new ImageIcon(this.getClass().getResource("/go.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int patientid = Integer.parseInt(textField.getText());
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt1 = con.createStatement();
				ResultSet rst = stmnt1.executeQuery("select addpatient.name from addpatient where patientid = '"+patientid+"'");
				while(rst.next()) {
					textField_1.setText(rst.getString("name"));
				}
			}
				catch(Exception eee) {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patientID");
					
				}
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(658, 217, 118, 36);
		panel.add(btnNewButton);
		

		lblNewLabel_1.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel_1);
		fillComboBox();	
	}
}