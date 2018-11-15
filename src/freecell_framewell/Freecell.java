package freecell_framewell;

public class Freecell implements CardStack {
	
	private int size;
	
	public Freecell() {
		this.size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	@Override
	public boolean cardCanBeAdded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cardCanBeRemoved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card removeCard() {
		// TODO Auto-generated method stub
		return null;
	}

}
