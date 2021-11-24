package hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import com.toedter.calendar.JDateChooser;

import database.dbconnection;

import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class update extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_9;
	//private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update window = new update();
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
	public update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 800, 800);
		setSize(800,700);
		setLocationRelativeTo(null);
		setResizable(false);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEDICINE UPDATE DETAILS");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setBounds(154, 28, 363, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("      M_ID:");
		lblNewLabel_1.setForeground(SystemColor.text);
		lblNewLabel_1.setBackground(UIManager.getColor("Button.disabledShadow"));
		lblNewLabel_1.setBounds(124, 113, 143, 30);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME:");
		lblNewLabel_2.setForeground(SystemColor.text);
		lblNewLabel_2.setBounds(154, 168, 90, 23);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRICE:");
		lblNewLabel_3.setForeground(SystemColor.text);
		lblNewLabel_3.setBounds(154, 235, 90, 23);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STOCK:");
		lblNewLabel_4.setForeground(SystemColor.text);
		lblNewLabel_4.setBounds(154, 305, 106, 23);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" P_DATE:");
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setBounds(154, 378, 106, 23);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(318, 112, 252, 30);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(318, 167, 252, 30);
		textField_1.setColumns(10);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_2.setBounds(318, 228, 252, 36);
		textField_2.setColumns(10);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_3.setBounds(318, 304, 252, 30);
		textField_3.setColumns(10);
		getContentPane().add(textField_3);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(318, 378, 252, 30);
		dateChooser.setFont(new Font("Arial", Font.PLAIN, 18));
		getContentPane().add(dateChooser);
		dateChooser.setDateFormatString("dd-MM-yyyy");
		
		JButton btnNewButton = new JButton("UPDATE");
		Image img2 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id=textField.getText();
				String name=textField_1.getText();
				float price=Float.parseFloat(textField_2.getText());
				int stock=Integer.parseInt(textField_3.getText());
				DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				String date=df.format(dateChooser.getDate());
				textField.setText(null);
				textField_1.setText(null);
				textField_2.setText(null);
				textField_3.setText(null);
				
					try{
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					
					ResultSet rs=stmnt.executeQuery("SELECT* from medicine WHERE m_id='"+id+"' ");
					
					if(rs.next()!=false){

						do{
						int s=rs.getInt("stock");
						System.out.println(s);
						int a=0;
						a=Integer.valueOf(stock);
						s=a+s;
						String b;
						b=String.valueOf(s);
						stmnt.executeUpdate("update medicine set price='"+price+"', stock='"+b+"', p_date='"+date+"' WHERE m_id='"+id+"'");
						}while(rs.next());
						
						
					}
					else{
						stmnt.executeUpdate("insert into medicine values('"+id+"', '"+name+"', '"+price+"', '"+stock+"', '"+date+"')");
						JOptionPane.showMessageDialog(rootPane, "medicine information is added successfully.");
					}
			}
				catch(Exception e) {
					
					
					System.out.println(e);}
			}
		});
		btnNewButton.setBounds(259, 497, 208, 54);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(btnNewButton);
		
		
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
		
		
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(-47, 0, 843, 672);
		getContentPane().add(lblNewLabel_6);
		Image img1 = new ImageIcon(this.getClass().getResource("/ph5.jpg")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon (img1));
	}
}