package freecell_framewell;

import java.util.ArrayList;
/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 * This is the Table class for the Freecell program
 * it is in charge of the the actions for the Table
 */
public class Table {
	
	private ArrayList<Freecell> freecells = new ArrayList<Freecell>(4);
	private ArrayList<Foundation> foundations = new ArrayList<Foundation>(4);
	private ArrayList<Tableau> tableaux = new ArrayList<Tableau>(8);
	private Deck deck;
	
	/**
	 * This is the default constructor for the table class
	 * it is in charge of creating a default table
	 */
	public Table() {
		
		this.foundations.add(new Foundation(Suit.Hearts));
		this.foundations.add(new Foundation(Suit.Diamonds));
		this.foundations.add(new Foundation(Suit.Spades));
		this.foundations.add(new Foundation(Suit.Clubs));
		
		for (int i = 0; i < 4; i++) {
			this.freecells.add(new Freecell());
		}
		
		for (int i = 0; i < 8; i++) {
			this.tableaux.add(new Tableau());
		}
		
		deck = new Deck();
		dealCards();
		
	}
	
	/**
	 * This is the dealCards method for the Table class
	 * it is in charge of dealing the cards to the table
	 */
	public void dealCards() {
		
		while (deck.size() > 0) {
			for (Tableau tableau : tableaux) {
				if (deck.size() != 0) {
					tableau.addCard(deck.deal());
				}
			}
		}
		
	}
	/**
	 * This is the printTable method for the Table class
	 * it is in charge of printing the table to the console
	 */
	public void printTable() {
		
		System.out.println("\nFoundations");
		for (int i = 0; i < foundations.size(); i++) {
			if (foundations.get(i).isEmpty()) {
				System.out.println("Empty");
			} else {
				System.out.println(foundations.get(i).getTopCard());
			}
		}
	
		System.out.println("\nFreecells");
		for (int i = 0; i < freecells.size(); i++) {
			if (freecells.get(i).isEmpty()) {
				System.out.println("Empty");
			} else {
				System.out.println(freecells.get(i).getTopCard());
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < tableaux.size(); i++) {
			System.out.println("\nTableau " + i);
			for (int j = 0; j < tableaux.get(i).getSize(); j++) {
				System.out.println(tableaux.get(i).getTableau().get(j));
			}
			
		}
		
		System.out.println();
		
	}
	/**
	 * This is the hasWon method for the Table class
	 * it is charge of determining if the player has won
	 * @return if the player has won
	 */
	public boolean hasWon() {
		return getFoundation(0).getSize() == 13 && getFoundation(1).getSize() == 13 && 
			   getFoundation(2).getSize() == 13 && getFoundation(3).getSize() == 13;
	}

	// Might not need these getters and setters but they're here just in case
	/**
	 * this is the getFreecells method for the Table class
	 * it is in charge of getting multiple freecells
	 * @return the freecells
	 */
	public ArrayList<Freecell> getFreecells() {
		return freecells;
	}
	
	/**
	 * This is the getFreecells method for the Table class
	 * it is in charge of getting one freecell
	 * @param index the index of the freecell
	 * @return the freecell
	 */
	public Freecell getFreecell(int index) {
		return freecells.get(index);
	}
	/**
	 * This is the setFreecells method for the Table class
	 * it is in charge of setting multiple freecelss
	 * @param freecells the freecells to be set
	 */
	public void setFreecells(ArrayList<Freecell> freecells) {
		this.freecells = freecells;
	}

	/**
	 * This is the getTableaux method for the table class 
	 * it is in charge of getting multiple tableaux
	 * @return the tableaux
	 */
	public ArrayList<Tableau> getTableaux() {
		return tableaux;
	}
	/**
	 * this is the getTableaux method for the table class
	 * it is in charge of getting a singe tableau
	 * @param index the index to be got by
	 * @return the tableau
	 */
	public Tableau getTableau(int index) {
		return tableaux.get(index);
	}
	/**
	 * This is the setTableaux method for the table class
	 * it is in charge of setting the tableau
	 * @param tableaux the tableaux to be set
	 */
	public void setTableaux(ArrayList<Tableau> tableaux) {
		this.tableaux = tableaux;
	}

	/**
	 * This is the getFoundations method for the table class
	 * it is in charge of getting multiple foundation
	 * @return the foundation
	 */
	public ArrayList<Foundation> getFoundations() {
		return foundations;
	}
	/**
	 * This is the getFoundation method for the table class
	 * it is in charge of getting a single foundation
	 * @param index the index of the foundation
	 * @return the foundation
	 */
	public Foundation getFoundation(int index) {
		return foundations.get(index);
	}
	/**
	 * This is the setFoundation method for the Table class
	 * it is in charge of setting foundations
	 * @param foundations the foundation to be set to
	 */
	public void setFoundations(ArrayList<Foundation> foundations) {
		this.foundations = foundations;
	}

}
