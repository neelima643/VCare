package hospital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ScrollPaneConstants;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import database.dbconnection;
import net.proteanit.sql.DbUtils;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class list extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ButtonGroup G1;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					list frame = new list();
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
	public list() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 294, 729, 417);
		contentPane.add(scrollPane);
		
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
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("VIEW BY BLOOD GROUP");
		rdbtnNewRadioButton.setBounds(50, 100, 258, 41);
		rdbtnNewRadioButton.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("VIEW BY NAME");
		rdbtnNewRadioButton_1.setBounds(50, 174, 258, 41);
		rdbtnNewRadioButton_1.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(rdbtnNewRadioButton_1);
		
		G1=new ButtonGroup();
		G1.add(rdbtnNewRadioButton);
		G1.add(rdbtnNewRadioButton_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(341, 106, 352, 31);
		textField.setEnabled(true);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(341, 180, 352, 31);
		textField_1.setEnabled(true);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(240, 28, 248, 31);
		comboBox.setFont(new Font("Arial", Font.BOLD, 18));
		contentPane.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Doner", "Request"}));
		comboBox.setToolTipText("");
		
		JButton btnNewButton = new JButton("VIEW");
		Image img2 = new ImageIcon(this.getClass().getResource("/view.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setBounds(298, 240, 169, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opt = (String)comboBox.getSelectedItem();
				String bgroup=textField.getText();
				String name=textField_1.getText();
				int count =0;
				int enable =0;
				if(opt=="Doner")
				{ count=0;}
				else{
					count=1;
				}
				if(rdbtnNewRadioButton.isSelected()){
					//textField_1.setEnabled(false);
					name= "";
					enable =0;}
				if(rdbtnNewRadioButton_1.isSelected()){
					//textField.setEnabled(false);
					bgroup= "";
					enable =1;}
				textField.setText(null);
				textField_1.setText(null);
				try{
					Connection con = dbconnection.getCon();
					Statement stmnts = con.createStatement();
					if(count==0 && enable==0){
						ResultSet rs=stmnts.executeQuery("select * from doner where bloodgp='"+bgroup+"'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					}
					 if(count==0 && enable==1){
						ResultSet rs=stmnts.executeQuery("select * from doner where name='"+name+"'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					}
					if(count==1 && enable==0){
						ResultSet rs=stmnts.executeQuery("select * from request where bloodgp='"+bgroup+"'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					}
					if(count==1 && enable==1){
						ResultSet rs=stmnts.executeQuery("select * from request where name='"+name+"'");
						table.setModel(DbUtils.resultSetToTableModel(rs));
						table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
					}
					
			}
				catch(Exception excep) {
					
					JOptionPane.showMessageDialog(null,"some error occured incorrect details");
				}}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 787, 772);
		contentPane.add(lblNewLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/bloodbg.jpg")).getImage();
		lblNewLabel.setIcon(new ImageIcon (img1));
		
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
