package hospital;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.ScrollPaneConstants;
import javax.swing.table.*;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextArea;

public class billing extends JFrame {

	private JFrame frame;
	private JTextField medname;
	private JTextField amount;
	private JTable table;
	private JButton BILL;
	private JTextField patientid;
	private JLabel Patient_id;
	private JLabel tot;
	private JTextField tamt;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JTextArea medicines;
	//private float a[];
	//private int i=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					billing window = new billing();
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
	public billing() {
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
		
		JButton PRINT = new JButton("PRINT");
		PRINT.setFont(new Font("Arial", Font.BOLD, 18));
		PRINT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				}
				catch (PrinterException p) {
					p.printStackTrace();
				}
			}
		});
		PRINT.setBounds(123, 613, 105, 27);
		getContentPane().add(PRINT);
		
		JTextArea medicines = new JTextArea();
		medicines.setBounds(131, 85, 549, 57);
		getContentPane().add(medicines);

		JButton medcineget = new JButton("Search");
		//int pid = Integer.parseInt(patientid.getText());
		medcineget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int pid = Integer.parseInt(patientid.getText());
				
				try {
				Connection con = dbconnection.getCon();
				Statement stmnt = con.createStatement();
				ResultSet rs = stmnt.executeQuery("select medicines from addconsultationinfo where patientID = '"+pid+"'");
				
				while(rs.next()) {
					medicines.setText(rs.getString("medicines"));
				
				
				
				
			}
				
				
				
			
				}
				
				catch(Exception e6) {
					
					JOptionPane.showMessageDialog(rootPane, "Enter a valid patientID!");
					
				}
			}
		});
		medcineget.setBounds(640, 35, 85, 21);
		getContentPane().add(medcineget);

		patientid = new JTextField();
		patientid.setBounds(346, 34, 236, 24);
		getContentPane().add(patientid);
		patientid.setColumns(10);

		JLabel Patient_id = new JLabel("Patient_id:");
		Patient_id.setBackground(Color.BLACK);
		Patient_id.setForeground(SystemColor.text);
		Patient_id.setFont(new Font("Arial", Font.BOLD, 18));
		Patient_id.setBounds(154, 30, 111, 27);
		getContentPane().add(Patient_id);
		
		
		JLabel Med_Name = new JLabel("Med_Name:");
		Med_Name.setForeground(SystemColor.text);
		Med_Name.setBackground(Color.BLACK);
		Med_Name.setBounds(154, 162, 111, 27);
		Med_Name.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(Med_Name);
		
		JLabel amt = new JLabel("Quantity:");
		amt.setForeground(SystemColor.text);
		amt.setBounds(154, 215, 94, 27);
		amt.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(amt);
		
		medname = new JTextField();
		medname.setFont(new Font("Arial", Font.PLAIN, 18));
		medname.setBounds(346, 161, 236, 27);
		getContentPane().add(medname);
		medname.setColumns(10);
		
		amount = new JTextField();
		amount.setFont(new Font("Arial", Font.PLAIN, 18));
		amount.setBounds(346, 214, 236, 27);
		getContentPane().add(amount);
		amount.setColumns(10);
		 
		 
		JButton ADD = new JButton("ADD");
		Image img2 = new ImageIcon(this.getClass().getResource("/addicon.jpg")).getImage();
		ADD.setIcon(new ImageIcon(img2));
		ADD.setBounds(131, 267, 137, 48);
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String med=medname.getText();
				int num=Integer.parseInt(amount.getText());
				float sum=0;
				float q;
				int p;
				
				//String med=search.getText();
				
				//String user=username.getText();
				  if (medname.getText().equals("")) {

					JOptionPane.showMessageDialog(null,"Fill name of medicine to be searched");}
				else{
					medname.setText(null);
					amount.setText(null);
					try{
						Connection con = dbconnection.getCon();
						Statement stmnt = con.createStatement();
						Statement billUpStmnt = con.createStatement();
						ResultSet rs = stmnt.executeQuery("select *from medicine where name='"+med+"'");
						//int count=rs.();
						if (!rs.isBeforeFirst() ) {    
							JOptionPane.showMessageDialog(rootPane, "medicine not available"); 
						} 
						while (rs.next()){
							p=rs.getInt("stock");
							q=rs.getFloat("price");
							System.out.println(q);
							sum=num*q;
							System.out.println(sum);
							if(p==0){
								JOptionPane.showMessageDialog(rootPane, "medicine not available");}
							else if(p<num){
								JOptionPane.showMessageDialog(rootPane, "less stock");}
							else{
								 billUpStmnt.executeUpdate("insert into bill(name,qty,price,total) VALUES('"+med+"', '"+num+"', '"+q+"', '"+sum+"')");}

								 
						}
						
						
						
				
						//System.out.println(count);
						
						
						//if(count==0){
						//	JOptionPane.showMessageDialog(null, "medicine not available or entered wrong medicine");}
								

						//table.setModel(DbUtils.resultSetToTableModel(rs));
						
					}
						
					
						
						catch(Exception e) {
							
							System.out.println(e);}
						
					
				}
				
				
				//String user=username.getText();
				 
			}
		});
		ADD.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(ADD);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 334, 476, 242);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		//table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(table);
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] { 
			}
		));
		
		BILL = new JButton("BILL");
		Image img3 = new ImageIcon(this.getClass().getResource("/bill.png")).getImage();
		BILL.setIcon(new ImageIcon (img3));
		BILL.setBounds(466, 272, 129, 48);
		BILL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
try {
					
		
					Connection con = dbconnection.getCon();
					Statement stmnt = con.createStatement();
					Statement medUpStmnt = con.createStatement();
					
					//ResultSet r1 = stmnt.executeQuery("select name, age from addpatient");
					//table.setModel(DbUtils.resultSetToTableModel(r1));
					/*if(r1.next()) {
						String pname=r1.getString("name");
						int page=Integer.parseInt("age");
					}*/
						
					ResultSet rs = stmnt.executeQuery("select *from bill");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					ResultSet r= stmnt.executeQuery("select SUM(total) from bill");
					if( r.next()){
					String total=r.getString("SUM(total)");
					tamt.setText(total);
					ResultSet s = stmnt.executeQuery("select b.name as name,m.stock as stock,b.qty as qty from bill b JOIN medicine m  where b.name = m.name");
					while (s.next()){
						String e=s.getString("name");
						int d=Integer.parseInt(s.getString("stock"));
						int o=Integer.parseInt(s.getString("qty"));
						int k=d-o;
						System.out.println(e);
						medUpStmnt .executeUpdate("update medicine set stock='"+k+"' where name='"+e+"'");
						//s.next();
					}				
					//ResultSet stp = stmnt.executeQuery("delete from bill");
					}
						
					
					
					
					table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
				}
				
				catch(Exception excep) {
					
					System.out.println(excep);;
				}

			}	
		});
		BILL.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(BILL);
		
		tot = new JLabel("TOTAL:");
		tot.setForeground(SystemColor.text);
		tot.setBounds(346, 613, 79, 27);
		tot.setFont(new Font("Arial", Font.BOLD, 18));
		getContentPane().add(tot);
		
		tamt = new JTextField();
		tamt.setFont(new Font("Arial", Font.PLAIN, 18));
		tamt.setBounds(446, 612, 153, 33);
		getContentPane().add(tamt);
		tamt.setColumns(10);
		
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog(rootPane,
		            "Are you sure you want to close this window?", "Close Window?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        		try {
						
						
						Connection con = dbconnection.getCon();
						Statement stmnt = con.createStatement();
						 stmnt.executeUpdate("delete from bill");}
					catch(Exception excep) {
						
						System.out.println(excep);;
					}
		        		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		            //System.exit(0);
		        }
		        else
        		{setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);}

		    }
		});
		
		
		JLabel lblNewLabel = new JLabel("PRINT");
		lblNewLabel.setBounds(-37, 0, 833, 672);
		getContentPane().add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/ph5.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		
		JButton ADD_1 = new JButton("ADD");
		ADD_1.setFont(new Font("Arial", Font.BOLD, 18));
		ADD_1.setBounds(109, 283, 137, 48);
		getContentPane().add(ADD_1);
		
		
	}
}