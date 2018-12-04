package freecell_framewell;

import java.util.ArrayDeque;

public class Freecell implements CardStack {
	
	private ArrayDeque<Card> freecellCards;
	
	public Freecell() {
		this.freecellCards = new ArrayDeque<Card>();
	}

	public boolean isEmpty() {
		return freecellCards.isEmpty();
	}

	public int getSize() {
		return freecellCards.size();
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
		if (canBeAdded(cards)) {
			freecellCards.push(cards.pop());
		} else {
			System.out.println("Can't move cards here");
		}
	}

	/**
	 * Removes Card object from Freecell
	 * @return Card removed from Freecell
	 */
	public ArrayDeque<Card> removeCards(int index) {
		ArrayDeque<Card> removedCard = new ArrayDeque<Card>();
		removedCard.add(freecellCards.pop());
		return removedCard;
	}
	
	
	public Card getTopCard() {
		return freecellCards.getLast();
	}


}
