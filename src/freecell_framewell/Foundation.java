package freecell_framewell;

import java.util.ArrayDeque;

public class Foundation implements CardStack {
	
	private Suit suit;
	private ArrayDeque<Card> foundationCards;
	
	public Foundation(Suit suit) {
		this.suit = suit;
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
			return cards.getFirst().getSuit() == suit;
		} else {
			Card topCard = foundationCards.getLast();
			return topCard.getSuit() == cards.getFirst().getSuit() && topCard.getValue() == cards.getFirst().getValue() - 1;
		}
	}

	public boolean canBeRemoved(Card card) {
		return false;
	}

	@Override
	public void addCard(ArrayDeque<Card> cards) {
		// TODO Auto-generated method stub
		
	}

	public ArrayDeque<Card> removeCards(int index) {
		return null;
	}

	
	public Card getTopCard() {
		return foundationCards.getLast();
	}

}
