package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import database.dbconnection;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class labreport extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					labreport frame = new labreport();
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
	public labreport() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 800);
		setAlwaysOnTop(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 796, 762);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 18));
		textField.setBounds(273, 41, 210, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("PATIENT ID");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(33, 40, 170, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LAB REPORT");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(296, 106, 164, 35);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(33, 151, 731, 549);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT NAME");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(55, 52, 158, 34);
		panel_1.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_1.setBounds(241, 52, 216, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("LOAD");
		Image img2 = new ImageIcon(this.getClass().getResource("/load.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int p= Integer.parseInt(textField.getText());
				try
				{
				Connection con=dbconnection.getCon();
				Statement stmnt=con.createStatement();
			     ResultSet rs = stmnt.executeQuery("Select name from testentry where patientID ='"+p+"'  ");
				
				while(rs.next())
				{
					textField_1.setText(rs.getString("name"));
				}
				ResultSet set = stmnt.executeQuery("select testentry.testtype,testentry.testdate, testentry.department,resultentry.resultdate,resultentry.component,resultentry.unit from resultentry,testentry where resultentry.patientID=testentry.patientID and testentry.patientID='"+p+"' ");
					table.setModel(DbUtils.resultSetToTableModel(set));

				
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(rootPane, "Some error occured.");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(523, 37, 184, 41);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 110, 731, 439);
		panel_1.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("PRINT");
		Image img3 = new ImageIcon(this.getClass().getResource("/print.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				}
				catch (PrinterException p) {
					p.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_1.setBounds(532, 710, 192, 42);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(0, 0, 796, 762);
		Image img1 = new ImageIcon(this.getClass().getResource("/t3.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon (img1));
		panel.add(lblNewLabel_3);
	}
}