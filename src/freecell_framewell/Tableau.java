package freecell_framewell;

import java.util.ArrayDeque;

public class Tableau implements CardStack {
	
	private int size;
	private ArrayDeque<Card> tableauCards;
	
	public Tableau() {
		this.size = 0;
		this.tableauCards = new ArrayDeque<Card>();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	@Override
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canBeRemoved(Card card) {
		// TODO Auto-generated method stub
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
