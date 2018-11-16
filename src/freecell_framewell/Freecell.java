package freecell_framewell;

import java.util.ArrayDeque;

public class Freecell implements CardStack {
	
	private int size;
	private ArrayDeque<Card> freecellCards;
	
	public Freecell() {
		this.size = 0;
		this.freecellCards = new ArrayDeque<Card>();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	/**
	 * Determines if Card object can be legally added to Freecell
	 * @return true if Card can be added to Freecell; otherwise false
	 */
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		return isEmpty() && cards.size() == 1;
	}

	/**
	 * Determines if Card object can be legally removed from Freecell
	 * @return true if Card can be removed from Freecell; otherwise false
	 */
	public boolean canBeRemoved(Card card) {
		return !isEmpty();
	}

	/**
	 * Adds Card object to Freecell
	 */
	public void addCard(ArrayDeque<Card> cards) {
		freecellCards.push(cards.pop());
		size++;
	}

	/**
	 * Removes Card object from Freecell
	 * @return Card removed from Freecell
	 */
	public Card removeCard() {
		size--;
		return freecellCards.pop();
	}

}
