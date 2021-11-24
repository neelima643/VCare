package hospital;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class medicinepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medicinepage frame = new medicinepage();
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
	public medicinepage() {
		
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
		
		JButton btnNewButton = new JButton("Availability");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new availability().setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/ph2.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setBounds(51, 180, 381, 73);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		Image img3 = new ImageIcon(this.getClass().getResource("/ph3.jpg")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new update().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(51, 283, 381, 81);
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 25));
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Billing");
		Image img4 = new ImageIcon(this.getClass().getResource("/ph4.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		btnNewButton_2.setBackground(SystemColor.textHighlight);
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBounds(51, 402, 381, 73);
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new billing().setVisible(true);
				
			}
		});
		panel.add(btnNewButton_2);
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
	
		
		
		JLabel lblNewLabel = new JLabel(" MEDICAL STORE");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 55));
		lblNewLabel.setBounds(449, 25, 583, 92);
		panel.add(lblNewLabel);

		
		JButton btnNewButton_3 = new JButton("Return to Home Page");
		Image img5 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img5));
		btnNewButton_3.setBackground(SystemColor.textHighlight);
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(rootPane, "Do you want to return to home page", "Select", JOptionPane.YES_NO_OPTION);
				if(close == 0) {
					setVisible(false);
					new homepage().setVisible(true);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 25));
		btnNewButton_3.setBounds(51, 505, 381, 67);
		panel.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-324, -44, 1893, 1067);
		panel.add(lblNewLabel_2);
		Image img1 = new ImageIcon(this.getClass().getResource("/ph1.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon (img1));
	}

}
