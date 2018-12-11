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
//		Image AOS = new ImageIcon(this.getClass().getResource("/AOS.png")).getImage();
//		Image AOH = new ImageIcon(this.getClass().getResource("/AOH.png")).getImage();
//		Image AOC = new ImageIcon(this.getClass().getResource("/AOC.png")).getImage();
//		Image AD = new ImageIcon(this.getClass().getResource("/AD.png")).getImage();
//		Image TwoS = new ImageIcon(this.getClass().getResource("/2S.png")).getImage();
//		Image TwoH = new ImageIcon(this.getClass().getResource("/2H.png")).getImage();
//		Image TwoC = new ImageIcon(this.getClass().getResource("/2C.png")).getImage();
//		Image TwoD = new ImageIcon(this.getClass().getResource("/2D.png")).getImage();
//		Image ThreeS = new ImageIcon(this.getClass().getResource("/3S.png")).getImage();
//		Image ThreeH = new ImageIcon(this.getClass().getResource("/3H.png")).getImage();
//		Image ThreeC = new ImageIcon(this.getClass().getResource("/3C.png")).getImage();
//		Image ThreeD = new ImageIcon(this.getClass().getResource("/3D.png")).getImage();
//		Image FourS = new ImageIcon(this.getClass().getResource("/4S.png")).getImage();
//		Image FourH = new ImageIcon(this.getClass().getResource("/4H.png")).getImage();
//		Image FourC = new ImageIcon(this.getClass().getResource("/4C.png")).getImage();
//		Image FourD = new ImageIcon(this.getClass().getResource("/4D.png")).getImage();
//		Image FiveS = new ImageIcon(this.getClass().getResource("/5S.png")).getImage();
//		Image FiveH = new ImageIcon(this.getClass().getResource("/5H.png")).getImage();
//		Image FiveC = new ImageIcon(this.getClass().getResource("/5C.png")).getImage();
//		Image FiveD = new ImageIcon(this.getClass().getResource("/5D.png")).getImage();
//		Image SixS = new ImageIcon(this.getClass().getResource("/6S.png")).getImage();
//		Image SixH = new ImageIcon(this.getClass().getResource("/6H.png")).getImage();
//		Image SixC = new ImageIcon(this.getClass().getResource("/6C.png")).getImage();
//		Image SixD = new ImageIcon(this.getClass().getResource("/6D.png")).getImage();
//		Image SevenS = new ImageIcon(this.getClass().getResource("/7S.png")).getImage();
//		Image SevenH = new ImageIcon(this.getClass().getResource("/7H.png")).getImage();
//		Image SevenC = new ImageIcon(this.getClass().getResource("/7C.png")).getImage();
//		Image SevenD = new ImageIcon(this.getClass().getResource("/7D.png")).getImage();
//		Image EightS = new ImageIcon(this.getClass().getResource("/8S.png")).getImage();
//		Image EightH = new ImageIcon(this.getClass().getResource("/8H.png")).getImage();
//		Image EightC = new ImageIcon(this.getClass().getResource("/8C.png")).getImage();
//		Image EightD = new ImageIcon(this.getClass().getResource("/8D.png")).getImage();
//		Image NineS = new ImageIcon(this.getClass().getResource("/9S.png")).getImage();
//		Image NineH = new ImageIcon(this.getClass().getResource("/9H.png")).getImage();
//		Image NineC = new ImageIcon(this.getClass().getResource("/9C.png")).getImage();
//		Image NineD = new ImageIcon(this.getClass().getResource("/9D.png")).getImage();
//		Image TenS = new ImageIcon(this.getClass().getResource("/10S.png")).getImage();
//		Image TenH = new ImageIcon(this.getClass().getResource("/10H.png")).getImage();
//		Image TenC = new ImageIcon(this.getClass().getResource("/10C.png")).getImage();
//		Image TenD = new ImageIcon(this.getClass().getResource("/10D.png")).getImage();
//		Image JackS = new ImageIcon(this.getClass().getResource("/JS.png")).getImage();
//		Image JackH = new ImageIcon(this.getClass().getResource("/JH.png")).getImage();
//		Image JackC = new ImageIcon(this.getClass().getResource("/JC.png")).getImage();
//		Image JackD = new ImageIcon(this.getClass().getResource("/JD.png")).getImage();
//		Image QueenS = new ImageIcon(this.getClass().getResource("/QS.png")).getImage();
//		Image QueenH = new ImageIcon(this.getClass().getResource("/QH.png")).getImage();
//		Image QueenC = new ImageIcon(this.getClass().getResource("/QC.png")).getImage();
//		Image QueenD = new ImageIcon(this.getClass().getResource("/QD.png")).getImage();
//		Image KingS = new ImageIcon(this.getClass().getResource("/KS.png")).getImage();
//		Image KingH = new ImageIcon(this.getClass().getResource("/KH.png")).getImage();
//		Image KingC = new ImageIcon(this.getClass().getResource("/KC.png")).getImage();
//		Image KingD = new ImageIcon(this.getClass().getResource("/KD.png")).getImage();
		
//		String cardName = testTable.getTableaux().get(0).getTopCard().getName().substring(0, 1);
//		String cardSuit = testTable.getTableaux().get(0).getTopCard().getSuit().toString().substring(0, 1);
//		String imgFileName = (cardName.equals("A")) ? "/" + cardName + "O" + cardSuit + ".png" : "/" + cardName + cardSuit + ".png";
//		Image imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();








		
		
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
		lblCardSpace1.setBounds(7, 75, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace1);
		
		lblCardSpace1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				X = arg0.getX();
				Y = arg0.getY();
			}
		});
		
		
//		JLabel lblCardSpace = new JLabel("");
//		lblCardSpace.setBounds(245, 284, 64, 64);
//		frmFreecell.getContentPane().add(lblCardSpace);
//		lblCardSpace.setIcon(new ImageIcon(AOH));
		
		JLabel lblCardSpace3 = new JLabel("");
		lblCardSpace3.setBounds(155, 75, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace3);
		
		JLabel lblCardSpace2 = new JLabel("");
		lblCardSpace2.setBounds(81, 75, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace2);
		
		JLabel lblCardSpace4 = new JLabel("");
		lblCardSpace4.setBounds(229, 75, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace4);
		
		String cardName = testTable.getTableaux().get(0).getTopCard().getName().substring(0, 1);
		String cardSuit = testTable.getTableaux().get(0).getTopCard().getSuit().toString().substring(0, 1);
		String imgFileName = (cardName.equals("A")) ? "/" + cardName + "O" + cardSuit + ".png" : "/" + cardName + cardSuit + ".png";
		Image imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace1.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTopCard().getSuit().toString().substring(0, 1);
		imgFileName = (cardName.equals("A")) ? "/" + cardName + "O" + cardSuit + ".png" : "/" + cardName + cardSuit + ".png";
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace2.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTopCard().getSuit().toString().substring(0, 1);
		imgFileName = (cardName.equals("A")) ? "/" + cardName + "O" + cardSuit + ".png" : "/" + cardName + cardSuit + ".png";
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace3.setIcon(new ImageIcon(imgFile));
		
		
		
		//Tableaux 0
//		if (testTable.getTableaux().get(0).getTopCard().getValue() == 1 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(AOS));
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 1 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts )
//		{
//			lblCardSpace1.setIcon(new ImageIcon(AOH));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 1 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(AD));
//
//		}
//		
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 1 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(AOC));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 2 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TwoS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 2 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TwoH));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 2 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TwoD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 2 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TwoC));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 3 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(ThreeS));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 3 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(ThreeH));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 3 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(ThreeC));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 3 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(ThreeD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 4 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FourS));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 4 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts )
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FourH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 4 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FourC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 4 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FourD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 5 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FiveS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 5 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FiveH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 5 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FiveC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 5 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FiveD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 6 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SixS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 6 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(FiveH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 6 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SixC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 6 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SixD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 7 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SevenS));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 7 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SevenH));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 7 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SevenC));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 7 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(SevenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 8 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(EightS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 8 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(EightH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 8 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(EightC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 8 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(EightD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 9 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(NineS));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 9 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(NineH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 9 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(NineC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 9 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(NineD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 10 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TenS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 10 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TenH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 10 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TenC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 10 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(TenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 11 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(JackS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 11 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(JackH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 11 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(JackC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 11 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(JackD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 12 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(QueenS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 12 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(QueenH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 12 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(QueenC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 12 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(QueenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 13 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(KingS));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 13 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(KingH));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 13 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(KingC));
//
//		}
//		else if(testTable.getTableaux().get(0).getTopCard().getValue() == 13 && testTable.getTableaux().get(0).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace1.setIcon(new ImageIcon(KingD));
//
//		}
//		
//		//Tableaux 1
//		
//		if (testTable.getTableaux().get(1).getTopCard().getValue() == 1 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(AOS));
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 1 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts )
//		{
//			lblCardSpace2.setIcon(new ImageIcon(AOH));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 1 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(AD));
//
//		}
//		
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 1 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(AOC));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 2 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TwoS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 2 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TwoH));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 2 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TwoD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 2 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TwoC));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 3 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(ThreeS));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 3 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(ThreeH));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 3 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(ThreeC));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 3 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(ThreeD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 4 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FourS));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 4 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts )
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FourH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 4 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FourC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 4 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FourD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 5 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FiveS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 5 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FiveH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 5 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FiveC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 5 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FiveD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 6 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SixS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 6 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(FiveH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 6 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SixC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 6 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SixD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 7 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SevenS));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 7 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SevenH));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 7 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SevenC));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 7 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(SevenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 8 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(EightS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 8 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(EightH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 8 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(EightC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 8 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(EightD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 9 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(NineS));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 9 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(NineH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 9 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(NineC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 9 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(NineD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 10 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TenS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 10 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TenH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 10 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TenC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 10 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(TenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 11 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(JackS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 11 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(JackH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 11 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(JackC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 11 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(JackD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 12 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(QueenS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 12 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(QueenH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 12 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(QueenC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 12 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(QueenD));
//
//		}
//		
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 13 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Spades)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(KingS));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 13 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Hearts)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(KingH));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 13 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Clubs)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(KingC));
//
//		}
//		else if(testTable.getTableaux().get(1).getTopCard().getValue() == 13 && testTable.getTableaux().get(1).getTopCard().getSuit() == Suit.Diamonds)
//		{
//			lblCardSpace2.setIcon(new ImageIcon(KingD));
//
//		}
		
		
		
		
		testTable.printTable();
		System.out.println(testTable.getTableaux().get(0).getSize());
	}
}
