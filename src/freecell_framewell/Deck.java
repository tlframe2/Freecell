package freecell_framewell;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Creates Deck object that represents a deck of playing cards
 * @author Tyrell Frame and Alex Sidwell
 */
public class Deck {
	
	// Holds 52 unique playing cards
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	/**
	 * This is the Default Deck constructor for the Deck class
	 * it is in charge of initializing an ArrayList with 52 cards
	 */
	public Deck() {
		
		// creates cards with values 2-14 for each of the four suits
		for (int i = 1; i <= 13; i++) {
			cards.add(new Card(i, Suit.Hearts));
			cards.add(new Card(i, Suit.Diamonds));
			cards.add(new Card(i, Suit.Spades));
			cards.add(new Card(i, Suit.Clubs));
		}
		
		// shuffles Deck
		shuffle();
		
	}
	
	/**
	 * This is the shuffle method for the deck class
	 *it is in charge of randomizing the order of cards in the Deck
	 */
	public void shuffle() {
		
		Collections.shuffle(cards);
		
	}
	
	/**
	 * This is the Deal method for the deck class
	 *it is in charge of  Removing the "top" from the Deck and dealing it out
	 * @return first Card object in ArrayList cards
	 */
	public Card deal() {
		
		return cards.remove(0);
		
	}
	
	/**
	 * This is the size method for the deck class
	 * it is in charge of getting the decks size
	 * @return the size of the deck
	 */
	public int size() {
		return cards.size();
	}

}
