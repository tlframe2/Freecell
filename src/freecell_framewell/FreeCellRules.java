package freecell_framewell;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FreeCellRules {

	private JFrame rules;

	/**
	 * Launch the application.
	 */
	public static void rules() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreeCellRules window = new FreeCellRules();
					window.rules.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FreeCellRules() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		rules = new JFrame();
		rules.setTitle("Rules");
		rules.getContentPane().setBackground(Color.WHITE);
		rules.setBounds(100, 100, 773, 464);
		rules.getContentPane().setLayout(null);
		
		JLabel lblRules = new JLabel("");
		lblRules.setBackground(Color.WHITE);
		Image img = new ImageIcon(this.getClass().getResource("/Rules.png")).getImage();
		lblRules.setIcon(new ImageIcon(img));
		lblRules.setBounds(0, 0, 568, 435);
		rules.getContentPane().add(lblRules);
		
		JButton btnResume = new JButton("Resume");
		btnResume.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rules.dispose();
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/PlayingCard.png")).getImage();
		btnResume.setIcon(new ImageIcon(img2));
		btnResume.setBounds(657, 389, 102, 35);
		rules.getContentPane().add(btnResume);
		
		JLabel lblPattern = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/CardPattern.png")).getImage();
		lblPattern.setIcon(new ImageIcon(img3));
		lblPattern.setBounds(606, 11, 128, 128);
		rules.getContentPane().add(lblPattern);
		
		JLabel lblPattern2 = new JLabel("");
		lblPattern2.setIcon(new ImageIcon(img3));
		lblPattern2.setBounds(606, 150, 128, 128);
		rules.getContentPane().add(lblPattern2);
		
		JLabel lblPattern3 = new JLabel("");
		lblPattern3.setIcon(new ImageIcon(img3));
		lblPattern3.setBounds(606, 289, 151, 114);
		rules.getContentPane().add(lblPattern3);
		
		
		
		
	}
}
