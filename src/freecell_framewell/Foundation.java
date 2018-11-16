package freecell_framewell;

import java.util.ArrayDeque;

public class Foundation implements CardStack {
	
	private int size;
	private Suit suit;
	private ArrayDeque<Card> foundationCards;
	
	public Foundation(Suit suit) {
		this.suit = suit;
		this.size = 0;
		this.foundationCards = new ArrayDeque<Card>();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
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

	@Override
	public Card removeCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
