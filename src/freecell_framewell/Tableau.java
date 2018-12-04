package freecell_framewell;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Tableau implements CardStack {
	
	private ArrayList<Card> tableauCards;
	
	public Tableau() {
		this.tableauCards = new ArrayList<Card>();
	}

	public boolean isEmpty() {
		return tableauCards.isEmpty();
	}

	public int getSize() {
		return tableauCards.size();
	}
	
	public ArrayList<Card> getTableau() {
		return tableauCards;
	}

	
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		Card topTableau = tableauCards.get(tableauCards.size() - 1);
		Card firstCard = cards.getFirst();
		
		return (firstCard.getValue() == topTableau.getValue() - 1 && !firstCard.getColor().equals(topTableau.getColor())) || isEmpty();
	}

	@Override
	public boolean canBeRemoved(Card card) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean canBeRemoved(int index) {
		
		Card current, next;
		
		for (int i = index; i < tableauCards.size() - 1; i++) {
			current = tableauCards.get(i);
			next = tableauCards.get(i + 1);
			if (current.getValue() != next.getValue() + 1 || current.getColor().equals(next.getColor())) {
				return false;
			}
		}
		
		return true;
	}

	public void addCard(ArrayDeque<Card> cards) {
		if (canBeAdded(cards)) {
			tableauCards.addAll(cards);
		}
		
	}
	
	public void addCard(Card card) {
		tableauCards.add(card);
	}

	public ArrayDeque<Card> removeCards(int index) {
		if (canBeRemoved(index)) {
			ArrayDeque<Card> removedCards = new ArrayDeque<Card>();
			for (int i = index; i < tableauCards.size(); i++) {
				removedCards.add(tableauCards.get(i));
			}
			tableauCards.removeAll(removedCards);
			return removedCards;
		}
	
		return null;
	}

	@Override
	public Card getTopCard() {
		return tableauCards.get(tableauCards.size() - 1);
	}

}
