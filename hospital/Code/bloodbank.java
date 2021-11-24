package hospital;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import hospital.donner;
import hospital.request;
import hospital.bloodavailability;
import hospital.list;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class bloodbank extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bloodbank frame = new bloodbank();
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
	public bloodbank() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1600, 900);
		setAlwaysOnTop(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("BLOOD BANK");
		lblNewLabel.setForeground(new Color(178, 34, 34));
		lblNewLabel.setBounds(546, 38, 640, 77);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 50));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Donate");
		Image img2 = new ImageIcon(this.getClass().getResource("/donate.png")).getImage();
		btnNewButton.setIcon(new ImageIcon (img2));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(728, 132, 428, 70);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new donner().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Request");
		Image img3 = new ImageIcon(this.getClass().getResource("/request.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.setIcon(new ImageIcon (img3));
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(new Color(178, 34, 34));
		btnNewButton_1.setBounds(728, 229, 428, 66);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new request().setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Availability");
		Image img4 = new ImageIcon(this.getClass().getResource("/availability.jpg")).getImage();
		btnNewButton_2.setIcon(new ImageIcon (img4));
		btnNewButton_2.setForeground(SystemColor.text);
		btnNewButton_2.setBackground(new Color(178, 34, 34));
		btnNewButton_2.setBounds(728, 316, 428, 70);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new bloodavailability().setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("List");
		Image img5 = new ImageIcon(this.getClass().getResource("/list.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon (img5));
		btnNewButton_3.setForeground(SystemColor.text);
		btnNewButton_3.setBackground(new Color(178, 34, 34));
		btnNewButton_3.setBounds(728, 427, 428, 66);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new list().setVisible(true);
				
			}
		});
		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 30));
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 1562, 853);


		
		JButton btnNewButton_4 = new JButton("Return to Home Page");
		Image img8 = new ImageIcon(this.getClass().getResource("/homeicon.jpg")).getImage();
		btnNewButton_4.setIcon(new ImageIcon (img8));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int close = JOptionPane.showConfirmDialog(rootPane, "Do you want to return to home page", "Select", JOptionPane.YES_NO_OPTION);
				if(close == 0) {
					setVisible(false);
					new homepage().setVisible(true);
				
				}
			}
		});
		btnNewButton_4.setForeground(SystemColor.text);
		btnNewButton_4.setBackground(new Color(178, 34, 34));
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 30));
		btnNewButton_4.setBounds(728, 521, 428, 70);
		contentPane.add(btnNewButton_4);
		Image img1 = new ImageIcon(this.getClass().getResource("/cropped-1920-1080-217652.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon (img1));
		contentPane.add(lblNewLabel_1);
		
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
