package freecell_framewell;

import java.util.ArrayDeque;
/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 * This is the Foundation class for the freecell program
 * it is in charge of the actions of the Foundations
 *
 */
public class Foundation implements CardStack {
	
	//private Suit suit;
	private ArrayDeque<Card> foundationCards;
	
	/**
	 * This is the overloaded constructor for the Foundation class
	 * it is in charge of creating the foundations
	 * @param suit the suit of the foundations
	 */
	public Foundation(Suit suit) {
		//this.suit = suit;
		this.foundationCards = new ArrayDeque<Card>();
	}

	/**
	 * This is the isEmpty method for the foundation class
	 * it is in charge of checking if the foundation is empty
	 * @return if the foundation is empty
	 */
	public boolean isEmpty() {
		return foundationCards.isEmpty();
	}
	
	/**
	 * This is the getSize method for the Foundation class
	 * it is in charge of getting the size of the foundation\
	 * @return the size of the foundation
	 */
	public int getSize() {
		return foundationCards.size();
	}
	
	/**
	 * This is the canBeAdded method for the Foundation class
	 * it is in charge of checking if a card can be added to the foundation
	 * @param cards the card to be added
	 * @return if the card can be added
	 */
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		if (cards.size() > 1) {
			return false;
		} else if (isEmpty()) {
			//return cards.getFirst().getSuit() == suit;
			return cards.getFirst().getValue() == 1;
		} else {
			Card topCard = foundationCards.getLast();
			return topCard.getSuit() == cards.getFirst().getSuit() && topCard.getValue() == cards.getFirst().getValue() - 1;
		}
	}
	
	
	/**
	 * This is the canBeRemoved method for the Foundation class
	 * it is not implemented and returns false as a card cannot be removed from a foundation
	 */
	public boolean canBeRemoved(int index) {
		return false;
	}

	/**
	 * This is the addCard method for the foundation class
	 * it is in charge of adding cards to a foundation
	 * @param cards the cards to be added
	 */
	public void addCard(ArrayDeque<Card> cards) {
		foundationCards.addLast(cards.pollFirst());
	}

	/**
	 * This is the removeCards method for the Foundation class
	 * it is not implemented because cards cannot be removed from the foundation
	 */
	public ArrayDeque<Card> removeCards(int index) {
		return null;
	}

	/**
	 * This is the getTopCard method for the Foundation class
	 * it is in charge of getting the top card from the foundation
	 * @return the card at the top
	 */
	public Card getTopCard() {
		return foundationCards.getLast();
	}

	/**
	 * This is the finalizeRemoval method for the Foundation class
	 * it is not implemented because cards cannot be removed from the foundation
	 */
	public void finalizeRemoval(int index) {
		// do nothing because nothing should be removed
	}

}
