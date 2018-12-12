package freecell_framewell;

import java.util.ArrayDeque;

public class Player {
	
	private ArrayDeque<Card> cardsBeingMoved;
	
//	public Player() {
//		this.cardsBeingMoved = new ArrayDeque<Card>();
//	}
	
//	public void setCardsToBeMoved(ArrayDeque<Card> cards) {
//		this.cardsBeingMoved = cards;
//	}
	
	// index is used for tableaux. cards starting at index until end of tableau will be selected if valid. index is irrelevant for freecells and foundations.
	public void moveCards(CardStack source, CardStack destination, int index) {
		
		cardsBeingMoved = source.removeCards(index);
		
		if (destination.canBeAdded(cardsBeingMoved)) {
			destination.addCard(cardsBeingMoved);
			source.finalizeRemoval(index);
		} else {
			System.out.println("Can't be done, chief");
			//source.addCard(cardsBeingMoved);
		}
		
		//cardsBeingMoved.clear();
		
		cardsBeingMoved = null;
		
		
	}

}
