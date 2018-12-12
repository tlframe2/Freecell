package freecell_framewell;

import java.util.ArrayDeque;

public class Foundation implements CardStack {
	
	//private Suit suit;
	private ArrayDeque<Card> foundationCards;
	
	public Foundation(Suit suit) {
		//this.suit = suit;
		this.foundationCards = new ArrayDeque<Card>();
	}

	public boolean isEmpty() {
		return foundationCards.isEmpty();
	}

	public int getSize() {
		return foundationCards.size();
	}

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

	public boolean canBeRemoved(int index) {
		return false;
	}

	public void addCard(ArrayDeque<Card> cards) {
		foundationCards.addLast(cards.pollFirst());
	}

	public ArrayDeque<Card> removeCards(int index) {
		return null;
	}

	
	public Card getTopCard() {
		return foundationCards.getLast();
	}

	public void finalizeRemoval(int index) {
		// do nothing because nothing should be removed
	}

}
