package freecell_framewell;

import java.util.ArrayDeque;

public interface CardStack {
	
	public boolean isEmpty();
	
	public int getSize();
	
	public boolean canBeAdded(ArrayDeque<Card> cards);
	
	//public boolean canBeRemoved(Card card);
	public boolean canBeRemoved(int index);
	
	public void addCard(ArrayDeque<Card> cards);
	
	public ArrayDeque<Card> removeCards(int index);
	
	public Card getTopCard();
	
	public void finalizeRemoval(int index);

}
