package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class request extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox_3;


	/**
	 * Launch the application.
	 */
	
	 public void fillCombo(){
			try{
				Connection con = dbconnection.getCon();
				Statement combo = con.createStatement();
				ResultSet r=combo.executeQuery("select * from addpatient");
				while(r.next()){
					//System.out.println(r.getString("patientID"));
					comboBox_3.addItem(r.getString("patientID"));
					
				}}
			catch(Exception e) {
				System.out.println(e);
			}}
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					request frame = new request();
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
	public request() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REQUEST FORM");
		lblNewLabel.setBounds(208, 10, 445, 58);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("NAME :");
		lblNewLabel_2.setBounds(79, 78, 173, 30);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AGE :");
		lblNewLabel_3.setBounds(79, 195, 173, 30);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PID :");
		lblNewLabel_4.setBounds(79, 291, 173, 35);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("GENDER :");
		lblNewLabel_5.setBounds(79, 406, 173, 30);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("BLOOD GROUP :");
		lblNewLabel_6.setBounds(79, 466, 173, 25);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("CAUSE :");
		lblNewLabel_7.setBounds(79, 578, 173, 39);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1 = new JLabel("SCHEME :");
		lblNewLabel_1.setBounds(79, 646, 173, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);

		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(396, 144, 279, 39);
		textField.setToolTipText("");
		textField.setText("  ");
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(396, 200, 279, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox.setBounds(396, 410, 279, 30);
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBox.setToolTipText("");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_1.setBounds(396, 470, 279, 30);
		contentPane.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "O+","AB+","A-","B-","O-","AB-"}));
		comboBox_1.setToolTipText("");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(396, 587, 279, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_2.setBounds(396, 650, 279, 30);
		contentPane.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_2.setToolTipText("");
		

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		dateChooser.setBounds(396, 247, 281, 30);
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		
		JLabel lblNewLabel_8 = new JLabel("ADDRESS :");
		lblNewLabel_8.setBounds(79, 144, 173, 30);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_8);

		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_4.setBounds(396, 83, 279, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setBounds(279, 707, 139, 46);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_4.getText();
				int units = Integer.parseInt(textField_6.getText());
				int age = Integer.parseInt(textField_1.getText());
				String bloodGp = (String)comboBox_1.getSelectedItem();
				String gender = (String)comboBox.getSelectedItem();
				String contact = textField_5.getText();
				String address = textField.getText();
				String scheme = (String)comboBox_2.getSelectedItem();
				String pid=(String)comboBox_3.getSelectedItem();
				String cause=textField_3.getText();
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				textField.setText(null);
				textField_1.setText(null);
				textField_3.setText(null);
				textField_4.setText(null);
				textField_5.setText(null);
				textField_6.setText(null);
				
				try{
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					stmnt.executeUpdate("insert into request values('"+name+"', '"+address+"', '"+age+"', '"+pid+"', '"+contact+"','"+gender+"','"+bloodGp+"','"+units+"','"+cause+"','"+scheme+"','"+date+"')");
					JOptionPane.showMessageDialog(rootPane,"request  details added sucessfully");	
					Statement requestUpd = con.createStatement();
					ResultSet sp=stmnt.executeQuery("select * from bloodbank where bloodgp='"+bloodGp+"'");
					
					while(sp.next()){
						int d=Integer.parseInt(sp.getString("units"));
						int imunit=d-units;
						
						requestUpd.executeUpdate("update bloodbank set units='"+imunit+"'where bloodgp='"+bloodGp+"'");
						System.out.println(imunit);
				}}
				
				
				catch(Exception e) {
					System.out.println(e);
				
					
					}

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT :");
		lblNewLabel_9.setBounds(79, 346, 173, 33);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_9);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setBounds(396, 352, 279, 30);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("UNITS :");
		lblNewLabel_10.setBounds(79, 525, 173, 30);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_10);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_6.setBounds(396, 525, 279, 39);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Arial", Font.PLAIN, 18));
		comboBox_3.setBounds(396, 297, 279, 30);
		contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_11 = new JLabel("DATE :");
		lblNewLabel_11.setBounds(79, 247, 173, 25);
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(0, 0, 786, 782);
		contentPane.add(lblNewLabel_12);
		Image img1 = new ImageIcon(this.getClass().getResource("/bloodbg.jpg")).getImage();
		lblNewLabel_12.setIcon(new ImageIcon (img1));
	
		fillCombo();
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(rootPane, 
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        				        		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);}
		        				        		else
		        				        		{setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);}

		            //System.exit(0);
		        
		    }
		});
		
	}

}
