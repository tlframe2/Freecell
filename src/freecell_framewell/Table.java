package freecell_framewell;

import java.util.ArrayList;

public class Table {
	
	//private ArrayList<CardStack> freecells;
	//private ArrayList<CardStack> tableaux;
	//private ArrayList<CardStack> foundations;
	
	private ArrayList<Freecell> freecells = new ArrayList<Freecell>(4);
	private ArrayList<Foundation> foundations = new ArrayList<Foundation>(4);
	private ArrayList<Tableau> tableaux = new ArrayList<Tableau>(8);
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
		dealCards();
		
	}
	
	public void dealCards() {
		
		while (deck.size() > 0) {
			for (Tableau tableau : tableaux) {
				if (deck.size() != 0) {
					tableau.addCard(deck.deal());
				}
			}
		}
		
	}
	
	public void printTable() {
		
		for (int i = 0; i < foundations.size(); i++) {
			if (foundations.get(i).isEmpty()) {
				System.out.print("Empty ");
			} else {
				System.out.print(foundations.get(i).getTopCard());
			}
		}
		
		System.out.print("\t");
		
		for (int i = 0; i < freecells.size(); i++) {
			if (freecells.get(i).isEmpty()) {
				System.out.print("Empty ");
			} else {
				System.out.print(freecells.get(i).getTopCard());
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < tableaux.size(); i++) {
			System.out.println("\nTableau " + i);
			for (int j = 0; j < tableaux.get(i).getSize(); j++) {
				System.out.println(tableaux.get(i).getTableau().get(j));
			}
			//System.out.println();
		}
		
	}
	
	public boolean hasWon() {
		return getFoundation(0).getSize() == 13 && getFoundation(1).getSize() == 13 && 
			   getFoundation(2).getSize() == 13 && getFoundation(3).getSize() == 13;
	}

	// Might not need these getters and setters but they're here just in case
	public ArrayList<Freecell> getFreecells() {
		return freecells;
	}
	
	public Freecell getFreecell(int index) {
		return freecells.get(index);
	}

	public void setFreecells(ArrayList<Freecell> freecells) {
		this.freecells = freecells;
	}

	public ArrayList<Tableau> getTableaux() {
		return tableaux;
	}
	
	public Tableau getTableau(int index) {
		return tableaux.get(index);
	}

	public void setTableaux(ArrayList<Tableau> tableaux) {
		this.tableaux = tableaux;
	}

	public ArrayList<Foundation> getFoundations() {
		return foundations;
	}
	
	public Foundation getFoundation(int index) {
		return foundations.get(index);
	}

	public void setFoundations(ArrayList<Foundation> foundations) {
		this.foundations = foundations;
	}

}
