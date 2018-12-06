package freecell_framewell;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;


public class FreeCellGUI {

	private JFrame frmFreecell;
	private int X,Y;
	private static Table testTable = new Table();
	private Player testPlayer = new Player();
	
	/**
	 * Launch the application.
	 */
	
	private Card aoc = new Card();
	private Tableau tab = new Tableau();
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FreeCellGUI window = new FreeCellGUI();
					window.frmFreecell.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FreeCellGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFreecell = new JFrame();
		frmFreecell.setTitle("Freecell");
		frmFreecell.getContentPane().setBackground(Color.GREEN);
		frmFreecell.setBounds(100, 100, 773, 464);
		frmFreecell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFreecell.getContentPane().setLayout(null);
		testTable.dealCards();
		Image AOS = new ImageIcon(this.getClass().getResource("/AOC.png")).getImage();
		Image AOH = new ImageIcon(this.getClass().getResource("/AOH.png")).getImage();
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FreeCellRules r = new FreeCellRules();
				r.rules();
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/PlayingCard.png")).getImage();
		btnRules.setIcon(new ImageIcon(img));
		btnRules.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		btnRules.setBounds(668, 389, 91, 35);
		frmFreecell.getContentPane().add(btnRules);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFreecell.dispose();
			}
		});
		btnQuit.setIcon(new ImageIcon(img));
		btnQuit.setBounds(338, 390, 105, 35);
		frmFreecell.getContentPane().add(btnQuit);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(7, 0, 64, 64);
		frmFreecell.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(81, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(155, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(229, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(683, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(610, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(536, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(462, 0, 64, 64);
		frmFreecell.getContentPane().add(panel_7);
		
		JLabel lblCardSpace1 = new JLabel("");
		lblCardSpace1.setBounds(7, 125, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace1);
		
		lblCardSpace1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				X = arg0.getX();
				Y = arg0.getY();
			}
		});
		
		if (testTable.getTableaux().get(0).getTopCard().getValue() == (1|2|3|4|5|6|7|8|9|10|11|12|13))
		{
			lblCardSpace1.setIcon(new ImageIcon(AOS));
		}
		
		testTable.printTable();
	}
}
