package hospital;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

import database.dbconnection;
import com.toedter.calendar.JDateChooser;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class donner extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_5;
	private JTextField textField;
	private JComboBox comboBox_3;

	/**
	 * Launch the application.
	 * 
	 */
	
	public void fillCombo(){
		try{
			Connection con = dbconnection.getCon();
			Statement combo = con.createStatement();
			ResultSet r=combo.executeQuery("select * from addpatient");
			while(r.next()){
				comboBox_3.addItem(r.getString("patientID"));
				
			}}
		catch(Exception e) {
			System.out.println(e);
		}}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					donner frame = new donner();
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
	public donner() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DONER'S  FORM");
		lblNewLabel.setBounds(191, 10, 411, 40);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME :");
		lblNewLabel_1.setBounds(42, 103, 170, 29);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE :");
		lblNewLabel_2.setBounds(42, 153, 170, 32);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("GENDER :");
		lblNewLabel_3.setBounds(42, 210, 170, 29);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("BLOOD GROUP :");
		lblNewLabel_4.setBounds(42, 261, 170, 29);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(372, 444, 302, 31);
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(dateChooser);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		JLabel lblNewLabel_5 = new JLabel("ADDRESS :");
		lblNewLabel_5.setBounds(42, 487, 170, 40);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("REPLACEMENT SCHEME :");
		lblNewLabel_6.setBounds(42, 586, 255, 29);
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_6);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(372, 212, 302, 28);
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Other"}));
		comboBox_1.setToolTipText("");
		

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(372, 586, 302, 29);
		comboBox_2.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(comboBox_2);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		comboBox_2.setToolTipText("");
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(372, 509, 302, 51);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(372, 263, 302, 29);
		comboBox.setFont(new Font("Arial", Font.PLAIN, 18));
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "B+", "O+","AB+","A-","B-","O-","AB-"}));
		comboBox.setToolTipText("");
		
		JLabel lblNewLabel_7 = new JLabel("If yes enter patient id :");
		lblNewLabel_7.setBounds(42, 644, 267, 29);
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("SUBMIT");
		Image img2 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setBounds(285, 702, 178, 51);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = textField_2.getText();
				int units =Integer.parseInt(textField_1.getText());
				int age = Integer.parseInt(textField.getText());
				String bloodGp = (String)comboBox.getSelectedItem();
				String gender = (String)comboBox_1.getSelectedItem();
				String contact = textField_5.getText();
				String address = textField_3.getText();
				String scheme = (String)comboBox_2.getSelectedItem();
				String pid;
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				if(scheme=="Yes") {
					comboBox_3.setEnabled(false);
					 pid =(String)comboBox_3.getSelectedItem();
					}
				else {
					  //pid = textField_4.getText();
					
					comboBox_3.setEnabled(false);
					pid = "null";
					
					} 
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					//textField_4.setText(null);
					textField_5.setText(null);
					
					try{
						Connection con = dbconnection.getCon();
						Statement stmnts = con.createStatement();
						Statement update = con.createStatement();
						
						stmnts.executeUpdate("insert into doner values('"+name+"', '"+age+"', '"+gender+"', '"+bloodGp+"', '"+units+"','"+contact+"','"+address+"','"+scheme+"','"+pid+"','"+date+"')");
						JOptionPane.showMessageDialog(rootPane,"doner details added sucessfully");
						ResultSet rs=stmnts.executeQuery("select * from bloodbank where bloodgp='"+bloodGp+"'");
						while(rs.next()){
							int d=Integer.parseInt(rs.getString("units"));
							System.out.println(d);
							int imunits=d+units;
							System.out.println(imunits);
							update.executeUpdate("update bloodbank set units='"+imunits+"'where bloodgp='"+bloodGp+"'");
						
						}
					}
					
					
					catch(Exception e) {
						System.out.println(e);
						//JOptionPane.showMessageDialog(null,"some error occured");}
				}
					
				}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_8 = new JLabel("UNITS :");
		lblNewLabel_8.setBounds(42, 324, 170, 29);
		lblNewLabel_8.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("CONTACT NO :");
		lblNewLabel_9.setBounds(42, 382, 170, 29);
		lblNewLabel_9.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_9);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setBounds(372, 107, 302, 29);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(372, 328, 302, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_5.setBounds(372, 385, 302, 32);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(372, 159, 302, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 comboBox_3 = new JComboBox();
		 comboBox_3.setFont(new Font("Arial", Font.PLAIN, 18));
		 comboBox_3.setBounds(372, 646, 302, 29);
		 contentPane.add(comboBox_3);
		
		JLabel lblNewLabel_10 = new JLabel("DATE :");
		lblNewLabel_10.setBounds(42, 444, 170, 29);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(0, 0, 786, 763);
		contentPane.add(lblNewLabel_11);
		Image img1 = new ImageIcon(this.getClass().getResource("/bloodbg.jpg")).getImage();
		lblNewLabel_11.setIcon(new ImageIcon (img1));
		
		
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


