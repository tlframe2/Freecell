package freecell_framewell;

import java.util.Stack;

public class Freecell implements CardStack {
	
	private int size;
	private Stack<Card> freecellCards;
	
	public Freecell() {
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	/**
	 * Determines if Card object can be added to Freecell. Card can only be added to empty Freecells.
	 * @return true if Card can be added to Freecell; otherwise false
	 */
	public boolean cardCanBeAdded() {
		return isEmpty();
	}

	/**
	 * Determines if Card object can be removed from Freecell. Card must be in Freecell in order to be removed.
	 * @return true if Card can be removed from Freecell; otherwise false;
	 */
	public boolean cardCanBeRemoved() {
		return !isEmpty();
	}

	/**
	 * Adds Card object to Freecell
	 */
	public void addCard(Card card) {
		freecellCards.push(card);
	}

	/**
	 * Removes Card object from Freecell
	 * @return Card removed from Freecell
	 */
	public Card removeCard() {
		return freecellCards.pop();
	}

}
