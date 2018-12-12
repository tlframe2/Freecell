package freecell_framewell;

import java.util.ArrayDeque;
/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 * This is the Player class for the Freecell program
 */
public class Player {
	
	private ArrayDeque<Card> cardsBeingMoved;
	
//	public Player() {
//		this.cardsBeingMoved = new ArrayDeque<Card>();
//	}
	
//	public void setCardsToBeMoved(ArrayDeque<Card> cards) {
//		this.cardsBeingMoved = cards;
//	}
	
	// index is used for tableaux. cards starting at index until end of tableau will be selected if valid. index is irrelevant for freecells and foundations.
	/**
	 * This is the moveCards method for the player class
	 * it is in charge of moving the cards via the players input
	 * @param source the source of where the card is taken from
	 * @param destination the destination of where the card is to go 
	 * @param index the index from where the card is taken from
	 */
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
