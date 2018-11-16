package freecell_framewell;

import java.util.ArrayDeque;

public interface CardStack {
	
	public boolean isEmpty();
	
	public int getSize();
	
	public boolean canBeAdded(ArrayDeque<Card> cards);
	
	public boolean canBeRemoved(Card card);
	
	public void addCard(ArrayDeque<Card> cards);
	
	public Card removeCard();

}
