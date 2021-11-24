package hospital;
import java.awt.image.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hospital.labrecords;
import hospital.labreport;
import hospital.resultentry;
import hospital.test;
import hospital.testentry;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class lab extends JFrame {

	private JPanel contentPane;
	private JButton btnupdate;
	private JButton btnedit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lab frame = new lab();
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
	public lab() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0,1600, 900);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Lab Records");
		Image img2 = new ImageIcon(this.getClass().getResource("/lab2.jpg")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new labrecords().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton.setBounds(71, 158, 365, 80);
		panel.add(btnNewButton);
		
		JButton btnTestEntry = new JButton("Test Entry");
		Image img3 = new ImageIcon(this.getClass().getResource("/lab3.png")).getImage();
		btnTestEntry.setIcon(new ImageIcon (img3));
		btnTestEntry.setBackground(SystemColor.textHighlight);
		btnTestEntry.setForeground(SystemColor.text);
		btnTestEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new testentry().setVisible(true);
				
			}
		});
		btnTestEntry.setFont(new Font("Arial", Font.BOLD, 25));
		btnTestEntry.setBounds(71, 259, 365, 80);
		panel.add(btnTestEntry);
		
		JButton btnResultEntry = new JButton("Result Entry");
		Image img4 = new ImageIcon(this.getClass().getResource("/lab4.jpg")).getImage();
		btnResultEntry.setIcon(new ImageIcon (img4));
		btnResultEntry.setForeground(SystemColor.text);
		btnResultEntry.setBackground(SystemColor.textHighlight);
		btnResultEntry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new resultentry().setVisible(true);
			}
		});
		btnResultEntry.setFont(new Font("Arial", Font.BOLD, 25));
		btnResultEntry.setBounds(71, 359, 365, 71);
		panel.add(btnResultEntry);
		
		JButton btnLabReports = new JButton("Lab Reports");
		Image img5 = new ImageIcon(this.getClass().getResource("/lab5.png")).getImage();
		btnLabReports.setIcon(new ImageIcon (img5));
		btnLabReports.setForeground(SystemColor.text);
		btnLabReports.setBackground(SystemColor.textHighlight);
		btnLabReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new labreport().setVisible(true);
			}
		});
		btnLabReports.setFont(new Font("Arial", Font.BOLD, 25));
		btnLabReports.setBounds(71, 449, 365, 71);
		panel.add(btnLabReports);
		
		JButton btnupdate;
		btnupdate = new JButton("Tests");
		Image img6 = new ImageIcon(this.getClass().getResource("/lab6.jpg")).getImage();
		btnupdate.setIcon(new ImageIcon (img6));
		btnupdate.setForeground(SystemColor.text);
		btnupdate.setBackground(SystemColor.textHighlight);
		btnupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 new test().setVisible(true);
			}
		});
		btnupdate.setFont(new Font("Arial", Font.BOLD, 25));
		btnupdate.setBounds(71, 542, 365, 80);
		panel.add(btnupdate);
		
     	JLabel lblNewLabel = new JLabel("");
     	lblNewLabel.setBackground(new Color(255, 255, 224));
		lblNewLabel.setBounds(-140, 0, 1730, 900);
		Image img1 = new ImageIcon(this.getClass().getResource("/lab1.jpg")).getImage();
		
		JButton btnHomePage = new JButton("Return to Home Page");
		btnHomePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(rootPane, "Do you want to return to home page", "Select", JOptionPane.YES_NO_OPTION);
				if(close == 0) {
					setVisible(false);
					new homepage().setVisible(true);
				
				}
			}
		});
		Image img7 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnHomePage.setIcon(new ImageIcon (img7));
		btnHomePage.setBackground(SystemColor.textHighlight);
		btnHomePage.setForeground(SystemColor.text);
		btnHomePage.setFont(new Font("Arial", Font.BOLD, 25));
		btnHomePage.setBounds(71, 642, 365, 71);
		panel.add(btnHomePage);
		
		JLabel lblNewLabel_1 = new JLabel("LABORATORY");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 55));
		lblNewLabel_1.setBounds(530, 25, 427, 90);
		panel.add(lblNewLabel_1);
		lblNewLabel.setIcon(new ImageIcon(img1));
		panel.add(lblNewLabel);


		
	
	}
}