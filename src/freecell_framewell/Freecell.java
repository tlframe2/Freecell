package freecell_framewell;

import java.util.ArrayDeque;
/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 *This is the Freecell class for the Freecell program 
 *it is in charge of the action of the Freecells
 */
public class Freecell implements CardStack {
	
	private ArrayDeque<Card> freecellCards;
	
	/**
	 * This is the default constructor for the Freecell class
	 * it is in charge of creating a default set of Freecells
	 */
	public Freecell() {
		this.freecellCards = new ArrayDeque<Card>();
	}

	/**
	 * This is the isEmpty method for the Freecell class
	 * it is in charge of checking if the Freecell is empty
	 * @return if the freecell is empty
	 */
	public boolean isEmpty() {
		return freecellCards.isEmpty();
	}

	/**
	 * This is the getSize method for the Freecell class
	 * it is in charge of getting the size of the freecell
	 * @return the size of the freecell
	 */
	public int getSize() {
		return freecellCards.size();
	}

	/**This is the canBeAdded method for the Freecell class
	 * Determines if Card object can be legally added to Freecell
	 * @return true if Card can be added to Freecell; otherwise false
	 */
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		return isEmpty() && cards.size() == 1;
	}

	/**
	 * This is the canBeRemoved method for the Freecell class
	 * Determines if Card object can be legally removed from Freecell
	 * @return true if Card can be removed from Freecell; otherwise false
	 */
	public boolean canBeRemoved(int index) {
		return !isEmpty();
	}

	/**
	 * This is the addCard method for the Freecell class
	 * it is in charge of adding cards to multiple freecells
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
	 * This is the removeCards method for the freecell class
	 * Removes Card object from Freecell
	 * @param index the index at which the cards will be removed from
	 * @return Card removed from Freecell
	 */
	public ArrayDeque<Card> removeCards(int index) {
		ArrayDeque<Card> removedCard = new ArrayDeque<Card>();
		removedCard.add(freecellCards.pop());
		return removedCard;
	}
	
	/**
	 * This is the getTopCard method for the Freecell class
	 * it is in charge of getting the top card of the freecell
	 * @return The top card of the freecell
	 */
	public Card getTopCard() {
		return freecellCards.getLast();
	}
	/**
	 * This is the finalizeRemoval method for the freecell class
	 * it is in charge of completely removing cards from a freecell
	 * @param index the index at which the cards will be removed
	 */
	public void finalizeRemoval(int index) {
		freecellCards.clear();
	}


}
