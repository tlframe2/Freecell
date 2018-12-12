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
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;

/**
 * @author Tyrell Frame and Alex Sidwell
 * This is the FreeCellGUI class for the Freecell project
 * it is in charge of the gameboard and all of the rules associated with it
 * 
 */
public class FreeCellGUI {

	private JFrame frmFreecell;
	private int X,Y;
	private static Table testTable = new Table();
	private Player testPlayer = new Player();
	private boolean drag = false;
	
	
	 // Launch the application.
	 
	
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
	 * This is the FreeCellGUI constructor
	 * it is in charge of running building the game
	 */
	public FreeCellGUI() {
		initialize();
	}

	
	//  Initialize the contents of the frame.
	 
	private void initialize() {
		frmFreecell = new JFrame();
		frmFreecell.setTitle("Freecell");
		frmFreecell.getContentPane().setBackground(Color.GREEN);
		frmFreecell.setBounds(100, 100, 827, 532);
		frmFreecell.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFreecell.getContentPane().setLayout(null);
		testTable.dealCards();
		testTable.printTable();
		
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
		btnRules.setBounds(720, 457, 91, 35);
		frmFreecell.getContentPane().add(btnRules);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFreecell.dispose();
			}
		});
		btnQuit.setIcon(new ImageIcon(img));
		btnQuit.setBounds(339, 458, 105, 35);
		frmFreecell.getContentPane().add(btnQuit);
		
		JLabel lblCardSpace1 = new JLabel("");
		lblCardSpace1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if(testTable.getTableau(0).canBeRemoved(6))
				{
					JComponent j = (JComponent)e.getSource();
					j.setLocation(j.getX() + e.getX(), j.getY() + e.getY() );
				}
			}
		});
		lblCardSpace1.setBounds(7, 307, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace1);
		
		lblCardSpace1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource() == lblCardSpace1) {
					drag = true;
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				drag = false;
				
			}
		});
		
	
		
		JLabel lblCardSpace3 = new JLabel("");
		lblCardSpace3.setBounds(155, 307, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace3);
		
		JLabel lblCardSpace2 = new JLabel("");
		lblCardSpace2.setBounds(81, 307, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace2);
		
		JLabel lblCardSpace4 = new JLabel("");
		lblCardSpace4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
		});
		lblCardSpace4.setBounds(229, 307, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace4);
		
		String cardName = testTable.getTableaux().get(0).getTopCard().getName().substring(0, 1);
		String cardSuit = testTable.getTableaux().get(0).getTopCard().getSuit().toString().substring(0, 1);
		String imgFileName;
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		Image imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace1.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace2.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace3.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace4.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace5 = new JLabel("");
		lblCardSpace5.setBounds(462, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace5);
		
		JLabel lblCardSpace6 = new JLabel("");
		lblCardSpace6.setBounds(536, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace6);
		
		JLabel lblCardSpace7 = new JLabel("");
		lblCardSpace7.setBounds(610, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace7);
		
		JLabel lblCardSpace8 = new JLabel("");
		lblCardSpace8.setBounds(683, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace8);
		
		cardName = testTable.getTableaux().get(4).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace5.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(5).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace6.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace7.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTopCard().getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTopCard().getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace8.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace9 = new JLabel("");
		lblCardSpace9.setBounds(7, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace9);
		
		JLabel lblCardSpace10 = new JLabel("");
		lblCardSpace10.setBounds(81, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace10);
		
		JLabel lblCardSpace11 = new JLabel("");
		lblCardSpace11.setBounds(155, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace11);
		
		JLabel lblCardSpace12 = new JLabel("");
		lblCardSpace12.setBounds(229, 277, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace12);
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace9.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace10.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace11.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace12.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace13 = new JLabel("");
		lblCardSpace13.setBounds(462, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace13);
		
		JLabel lblCardSpace14 = new JLabel("");
		lblCardSpace14.setBounds(536, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace14);
		
		JLabel lblCardSpace15 = new JLabel("");
		lblCardSpace15.setBounds(610, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace15);
		
		JLabel lblCardSpace16 = new JLabel("");
		lblCardSpace16.setBounds(683, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace16);
		
		cardName = testTable.getTableaux().get(4).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace13.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(5).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace14.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace15.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTableauxCard(2).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTableauxCard(2).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace16.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace17 = new JLabel("");
		lblCardSpace17.setBounds(7, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace17);
		
		JLabel lblCardSpace18 = new JLabel("");
		lblCardSpace18.setBounds(81, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace18);
		
		JLabel lblCardSpace19 = new JLabel("");
		lblCardSpace19.setBounds(155, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace19);
		
		JLabel lblCardSpace20 = new JLabel("");
		lblCardSpace20.setBounds(229, 244, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace20);
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace17.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace18.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace19.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace20.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace21 = new JLabel("");
		lblCardSpace21.setBounds(462, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace21);
			
		cardName = testTable.getTableaux().get(4).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace21.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace22 = new JLabel("");
		lblCardSpace22.setBounds(536, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace22);
		
		JLabel lblCardSpace23 = new JLabel("");
		lblCardSpace23.setBounds(610, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace23);
		
		JLabel lblCardSpace24 = new JLabel("");
		lblCardSpace24.setBounds(683, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace24);
		
		cardName = testTable.getTableaux().get(5).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace22.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace23.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTableauxCard(3).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTableauxCard(3).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace24.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace25 = new JLabel("");
		lblCardSpace25.setBounds(7, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace25);
		
		JLabel lblCardSpace26 = new JLabel("");
		lblCardSpace26.setBounds(81, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace26);
		
		JLabel lblCardSpace27 = new JLabel("");
		lblCardSpace27.setBounds(155, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace27);
		
		JLabel lblCardSpace28 = new JLabel("");
		lblCardSpace28.setBounds(229, 211, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace28);
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace25.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace26.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace27.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace28.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace29 = new JLabel("");
		lblCardSpace29.setBounds(462, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace29);
		
		JLabel lblCardSpace30 = new JLabel("");
		lblCardSpace30.setBounds(536, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace30);
		
		JLabel lblCardSpace31 = new JLabel("");
		lblCardSpace31.setBounds(610, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace31);
		
		JLabel lblCardSpace32 = new JLabel("");
		lblCardSpace32.setBounds(683, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace32);
		
		cardName = testTable.getTableaux().get(4).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace29.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(5).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace30.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace31.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTableauxCard(4).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTableauxCard(4).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace32.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace33 = new JLabel("");
		lblCardSpace33.setBounds(7, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace33);
		
		JLabel lblCardSpace34 = new JLabel("");
		lblCardSpace34.setBounds(81, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace34);
		
		JLabel lblCardSpace35 = new JLabel("");
		lblCardSpace35.setBounds(155, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace35);
		
		JLabel lblCardSpace36 = new JLabel("");
		lblCardSpace36.setBounds(229, 178, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace36);
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace33.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace34.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace35.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace36.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace40 = new JLabel("");
		lblCardSpace40.setBounds(683, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace40);
		
		JLabel lblCardSpace38 = new JLabel("");
		lblCardSpace38.setBounds(536, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace38);
		
		JLabel lblCardSpace39 = new JLabel("");
		lblCardSpace39.setBounds(610, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace39);
		
		JLabel lblCardSpace37 = new JLabel("");
		lblCardSpace37.setBounds(462, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace37);
		
		cardName = testTable.getTableaux().get(4).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace37.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(5).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace38.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace39.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTableauxCard(5).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTableauxCard(5).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace40.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace41 = new JLabel("");
		lblCardSpace41.setBounds(7, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace41);
		
		JLabel lblCardSpace42 = new JLabel("");
		lblCardSpace42.setBounds(81, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace42);
		
		JLabel lblCardSpace43 = new JLabel("");
		lblCardSpace43.setBounds(155, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace43);
		
		JLabel lblCardSpace44 = new JLabel("");
		lblCardSpace44.setBounds(229, 145, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace44);
		
		JLabel lblCardSpace45 = new JLabel("");
		lblCardSpace45.setBounds(462, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace45);
		
		JLabel lblCardSpace46 = new JLabel("");
		lblCardSpace46.setBounds(536, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace46);
		
		JLabel lblCardSpace47 = new JLabel("");
		lblCardSpace47.setBounds(610, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace47);
		
		JLabel lblCardSpace48 = new JLabel("");
		lblCardSpace48.setBounds(683, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace48);
		
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace41.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace42.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace43.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace44.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(4).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(4).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace45.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(5).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(5).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace46.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(6).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(6).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace47.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(7).getTableauxCard(6).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(7).getTableauxCard(6).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace48.setIcon(new ImageIcon(imgFile));
		
		JLabel lblCardSpace49 = new JLabel("");
		lblCardSpace49.setBounds(7, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace49);
		
		JLabel lblCardSpace50 = new JLabel("");
		lblCardSpace50.setBounds(81, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace50);
		
		JLabel lblCardSpace51 = new JLabel("");
		lblCardSpace51.setBounds(155, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace51);
		
		JLabel lblCardSpace52 = new JLabel("");
		lblCardSpace52.setBounds(229, 112, 64, 64);
		frmFreecell.getContentPane().add(lblCardSpace52);
		
		cardName = testTable.getTableaux().get(0).getTableauxCard(7).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(0).getTableauxCard(7).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace49.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(1).getTableauxCard(7).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(1).getTableauxCard(7).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace50.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(2).getTableauxCard(7).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(2).getTableauxCard(7).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace51.setIcon(new ImageIcon(imgFile));
		
		cardName = testTable.getTableaux().get(3).getTableauxCard(7).getName().substring(0, 1);
		cardSuit = testTable.getTableaux().get(3).getTableauxCard(7).getSuit().toString().substring(0, 1);
		if(cardName.equals("A")) {
			imgFileName = "/" + cardName + "O" + cardSuit + ".png";
		}
		else if(cardName.equals("1")) {
            imgFileName = "/" + cardName + "0" + cardSuit + ".png";
        } else {
            imgFileName = "/" + cardName + cardSuit + ".png";
        }
		imgFile = new ImageIcon(this.getClass().getResource(imgFileName)).getImage();
		lblCardSpace52.setIcon(new ImageIcon(imgFile));
		
		JLabel lblFoundation1 = new JLabel("");
		Image heart = new ImageIcon(this.getClass().getResource("/HeartFoundation.png")).getImage();
		lblFoundation1.setIcon(new ImageIcon(heart));
		lblFoundation1.setBounds(462, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFoundation1);
		
		JLabel lblFoundation2 = new JLabel("");
		Image Spade = new ImageIcon(this.getClass().getResource("/SpadesFoundation.png")).getImage();
		lblFoundation2.setIcon(new ImageIcon(Spade));
		lblFoundation2.setBounds(536, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFoundation2);
		
		JLabel lblFoundation3 = new JLabel("");
		Image diamond = new ImageIcon(this.getClass().getResource("/DiamondsFoundation.png")).getImage();
		lblFoundation3.setIcon(new ImageIcon(diamond));
		lblFoundation3.setBounds(609, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFoundation3);
		
		JLabel lblFoundation4 = new JLabel("");
		Image club = new ImageIcon(this.getClass().getResource("/ClubsFoundation.png")).getImage();
		lblFoundation4.setIcon(new ImageIcon(club));
		lblFoundation4.setBounds(683, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFoundation4);
		
		JLabel lblFreecell1 = new JLabel("");
		Image f = new ImageIcon(this.getClass().getResource("/f.png")).getImage();
		lblFreecell1.setIcon(new ImageIcon(f));
		lblFreecell1.setBounds(7, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFreecell1);
		
		JLabel lblFreecell2 = new JLabel("");
		Image r = new ImageIcon(this.getClass().getResource("/r.png")).getImage();
		lblFreecell2.setIcon(new ImageIcon(r));
		lblFreecell2.setBounds(81, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFreecell2);
		
		JLabel lblFreecell3 = new JLabel("");
		Image e = new ImageIcon(this.getClass().getResource("/e.png")).getImage();
		lblFreecell3.setIcon(new ImageIcon(e));
		lblFreecell3.setBounds(155, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFreecell3);
		
		JLabel lblFreecell4 = new JLabel("");
		lblFreecell4.setIcon(new ImageIcon(e));
		lblFreecell4.setBounds(229, 0, 64, 64);
		frmFreecell.getContentPane().add(lblFreecell4);
	
		testTable.printTable();
		
	}
}
