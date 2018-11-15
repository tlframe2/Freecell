package freecell_framewell;

import java.util.ArrayList;

public class Table {
	
	private ArrayList<CardStack> freecells;
	private ArrayList<CardStack> tableaux;
	private ArrayList<CardStack> foundations;
	private Deck deck;
	
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
		
	}

	// Might not need these getters and setters but they're here just in case
	public ArrayList<CardStack> getFreecells() {
		return freecells;
	}

	public void setFreecells(ArrayList<CardStack> freecells) {
		this.freecells = freecells;
	}

	public ArrayList<CardStack> getTableaux() {
		return tableaux;
	}

	public void setTableaux(ArrayList<CardStack> tableaux) {
		this.tableaux = tableaux;
	}

	public ArrayList<CardStack> getFoundations() {
		return foundations;
	}

	public void setFoundations(ArrayList<CardStack> foundations) {
		this.foundations = foundations;
	}

}
