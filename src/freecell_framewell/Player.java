package freecell_framewell;

import java.util.ArrayDeque;

public class Player {
	
	private ArrayDeque<Card> cardsBeingMoved;
	
	public Player() {
		this.cardsBeingMoved = new ArrayDeque<Card>();
	}
	
	// index is used for tableaux. cards starting at index until end of tableau will be selected if valid. index is irrelevant for freecells and foundations.
	public void moveCards(CardStack source, CardStack destination, int index) {
		
		cardsBeingMoved = source.removeCards(index);
		destination.addCard(cardsBeingMoved);
		
	}

}
