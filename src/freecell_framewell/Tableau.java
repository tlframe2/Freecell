package freecell_framewell;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Tyrell Frame and Alex Sidwell
 * This is the Tableau class for the Free cell program 
 * it is in charge of the actions of the Tableau
 *
 */
public class Tableau implements CardStack {
	
	//private ArrayList<Card> tableauCards;
	private List<Card> tableauCards;
	//private ArrayDeque<Card> tempRemovedCards;
	/**
	 * This is the default constructor for the tableau class
	 * it is in charge of creating a default tableau class
	 */
	public Tableau() {
		this.tableauCards = new ArrayList<Card>();
	}

	/**
	 * This is the isEmpty method for the tableau class
	 * it is in charge of checking if the tableau is empty
	 * @return if the tableau is empty
	 * 
	 */
	public boolean isEmpty() {
		return tableauCards.isEmpty();
	}
/**
 * This is the getSize method for the Tableau class
 * it is in charge of getting the size of the Tableau
 * @return the size of the Tableau
 */
	public int getSize() {
		return tableauCards.size();
	}
	
//	public ArrayList<Card> getTableau() {
//		return tableauCards;
//	}
	
	/**
	 * This is the getTableau method for the Tableau class
	 * it is in charge of getting the tableau
	 * @return the tableau
	 */
	public List<Card> getTableau() {
		return tableauCards;
	}

	/**
	 * This is the canBeAdded method for the Tableau
	 * it is in charge of checking if a card can be added
	 * @param cards the cards to be added
	 * @return if the card can be added
	 */
	public boolean canBeAdded(ArrayDeque<Card> cards) {
		Card topTableau = tableauCards.get(tableauCards.size() - 1);
		Card firstCard = cards.getFirst();
		
		return (firstCard.getValue() == topTableau.getValue() - 1 && !firstCard.getColor().equals(topTableau.getColor())) || isEmpty();
	}

//	@Override
//	public boolean canBeRemoved(Card card) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	/**
	 * This is the canBeRemoved method for the Tableau class
	 * it is in charge of checking if a card can be removed
	 * @param index the index of the card
	 * @return if the card can be removed
	 */
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

	/**
	 * This is the addCard method for the Tableau class
	 * it is in charge of adding multiple cards in the tableau
	 * @param cards the cards to be added
	 */
	public void addCard(ArrayDeque<Card> cards) {
		if (canBeAdded(cards)) {
			tableauCards.addAll(cards);
		}
		
	}
	
	/**
	 * This is the addCard method for the tableau class
	 * it is in charge of adding a card in the tableau
	 * @param card the card to be added
	 */
	public void addCard(Card card) {
		tableauCards.add(card);
	}

	/**
	 * This is the removeCards method for the Tableau class
	 * it is in charge of removing cards in the tableau
	 * @param index the index of the cards to be removed
	 * @return the cards to be removed
	 */
	public ArrayDeque<Card> removeCards(int index) {

		ArrayDeque<Card> removedCards = new ArrayDeque<Card>();
		for (int i = index; i < tableauCards.size(); i++) {
			removedCards.add(tableauCards.get(i));
		}
		
		return removedCards;
	}

	/**
	 * This is the getTopCard method for the Tableau class
	 * it is in charge of getting the top card in the tableau
	 * @return the top card
	 */
	public Card getTopCard() {
		return tableauCards.get(tableauCards.size() - 1);
	}
	
	/**
	 * This is the getTableauxCard method for the Tableau class
	 * it is in charge of getting a specific card in the tableau
	 * @param i the index of the card
	 * @return the card
	 */
	public Card getTableauxCard(int i)
	{
		return tableauCards.get(tableauCards.size() - i);
	}

	/**
	 * This is the finalizeRemoval method for the Tableau class
	 * it is in charge of finalizing the removal of a card in the Tableau
	 * @param index the index of the card
	 */
	public void finalizeRemoval(int index) {
		tableauCards = tableauCards.subList(0, index);
	}
}
