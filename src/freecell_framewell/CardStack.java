package freecell_framewell;

public interface CardStack {
	
	public boolean isEmpty();
	
	public int getSize();
	
	public boolean cardCanBeAdded();
	
	public boolean cardCanBeRemoved();
	
	public void addCard();
	
	public Card removeCard();

}
