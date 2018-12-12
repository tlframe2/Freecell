package freecell_framewell;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 * This is the FreecellStartPage Class for the Freecell program
 * it is in charge of running the start page for the player
 */
public class FreecellStartPage {

	private JFrame FrameWell_Freecell;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreecellStartPage window = new FreecellStartPage();
					window.FrameWell_Freecell.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This is the constructor for the FreecellStartPage class
	 * it is in charge of initializing the contents of the frame
	 */
	public FreecellStartPage() {
		initialize();
	}

	private void initialize() {
		FrameWell_Freecell = new JFrame();
		FrameWell_Freecell.setTitle("FrameWell_FreeCell");
		FrameWell_Freecell.getContentPane().setBackground(Color.GREEN);
		FrameWell_Freecell.setBackground(Color.WHITE);
		FrameWell_Freecell.setBounds(100, 100, 505, 331);
		FrameWell_Freecell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FrameWell_Freecell.getContentPane().setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FreeCellGUI FGUI = new FreeCellGUI();
				FGUI.newScreen();
				FrameWell_Freecell.setVisible(false);
				
			}
		});
	
		btnPlay.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		Image img = new ImageIcon(this.getClass().getResource("/PlayingCard.png")).getImage();
		btnPlay.setIcon(new ImageIcon(img));
		btnPlay.setBounds(206, 179, 89, 23);
		FrameWell_Freecell.getContentPane().add(btnPlay);
		
		JLabel lblFreecell = new JLabel("Freecell");
		lblFreecell.setFont(new Font("Viner Hand ITC", Font.PLAIN, 18));
		lblFreecell.setBounds(219, 149, 99, 30);
		FrameWell_Freecell.getContentPane().add(lblFreecell);
		
		
		JLabel lblKing = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/King-icon.png")).getImage();
		lblKing.setIcon(new ImageIcon(img2));
		lblKing.setBounds(179, 31, 139, 123);
		FrameWell_Freecell.getContentPane().add(lblKing);
}
}