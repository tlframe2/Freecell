package freecell_framewell;

import java.util.ArrayDeque;

public class Player {
	
	private ArrayDeque<Card> cardsBeingMoved;
	
	public Player() {
		this.cardsBeingMoved = new ArrayDeque<Card>();
	}

}
