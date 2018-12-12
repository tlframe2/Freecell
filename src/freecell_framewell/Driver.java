package freecell_framewell;

public class Driver {

	public static void main(String[] args) {
		
		Table testTable = new Table();
		Player testPlayer = new Player();
		
		testTable.printTable();
		testPlayer.moveCards(testTable.getTableau(0), testTable.getFreecell(0), 6);
		testTable.printTable();
		testPlayer.moveCards(testTable.getTableau(0), testTable.getFreecell(0), 5);
		
		test();
		
		ConsoleGame newGame = new ConsoleGame();
		newGame.startGame();

	}
	
	public static void test()
	{
		System.out.println("------------------------------------------------CARD TESTS------------------------------------------------");

		System.out.println("Testing the overloaded construcor for the Card class ");
		System.out.println("The values being tested are: a value of one and a suit of Spades ");
		System.out.println("The expected results are: Ace of Spades");
		System.out.println("The actual results are: ");
		Card card1 = new Card(1, Suit.Spades);
		System.out.println(card1);
		System.out.println(" ");
			

		System.out.println("Testing the getValue method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 1");
		System.out.println("The expected results are: 1");
		System.out.println("The actual results are: ");
		System.out.println(card1.getValue());
		System.out.println(" ");

		System.out.println("Testing the getName method on the created Card card1 ");
		System.out.println("The values being tested are: a name of Ace");
		System.out.println("The expected results are: Ace");
		System.out.println("The actual results are: ");
		System.out.println(card1.getName());
		System.out.println(" ");

		System.out.println("Testing the getSuit method on the created Card card1 ");
		System.out.println("The values being tested are: a value of Spades");
		System.out.println("The expected results are: Spades");
		System.out.println("The actual results are: ");
		System.out.println(card1.getSuit());
		System.out.println(" ");


		System.out.println("Testing the get method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 1");
		System.out.println("The expected results are: 1");
		System.out.println("The actual results are: ");
		System.out.println(card1.getValue());
		System.out.println(" ");


		System.out.println("Testing the setValue method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 2");
		System.out.println("The expected results are: 2");
		System.out.println("The actual results are: ");
		card1.setValue(2);
		System.out.println(card1.getValue());
		System.out.println(" ");

		System.out.println("Testing the setValue method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 11");
		System.out.println("The expected results are: 11");
		System.out.println("The actual results are: ");
		card1.setValue(11);
		System.out.println(card1.getValue());
		System.out.println(" ");

		System.out.println("Testing the setValue method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 12");
		System.out.println("The expected results are: 12");
		System.out.println("The actual results are: ");
		card1.setValue(12);
		System.out.println(card1.getValue());
		System.out.println(" ");

		System.out.println("Testing the setValue method on the created Card card1 ");
		System.out.println("The values being tested are: a value of 13");
		System.out.println("The expected results are: 13");
		System.out.println("The actual results are: ");
		card1.setValue(13);
		System.out.println(card1.getValue());
		System.out.println(" ");

		System.out.println("Testing the setSuit method on the created Card card1 ");
		System.out.println("The values being tested are: a suit of Hearts");
		System.out.println("The expected results are: Hearts");
		System.out.println("The actual results are: ");
		card1.setSuit(Suit.Hearts);
		System.out.println(card1.getSuit());
		System.out.println(" ");

		System.out.println("Testing the isVisible method on the created Card card1 ");
		System.out.println("The values being tested are: The visibility of true");
		System.out.println("The expected results are: true");
		System.out.println("The actual results are: ");
		System.out.println(card1.isVisible());
		System.out.println(" ");

		System.out.println("Testing the hide method on the created Card card1 ");
		System.out.println("The values being tested are: a card that is visible");
		System.out.println("The expected results are: 'Hidden Card' ");
		System.out.println("The actual results are: ");
		card1.hide();
		System.out.println(card1);
		System.out.println(" ");

		System.out.println("Testing the show method on the created Card card1 ");
		System.out.println("The values being tested are: a card that is hidden");
		System.out.println("The expected results are: King of hearts");
		System.out.println("The actual results are: ");
		card1.show();
		System.out.println(card1);
		System.out.println(" ");

		System.out.println("------------------------------------------------Deck TESTS------------------------------------------------");

		System.out.println("");

		System.out.println("Testing the constructor for the deck class ");
		System.out.println("The values being tested are: a deck of 52 cards");
		System.out.println("The expected results are: a created deck of 52 cards");
		System.out.println("The actual results are: ");
		Deck deck = new Deck();
		System.out.println(deck.toString());
		System.out.println(" ");

		System.out.println("Testing the shuffle method on the created Deck deck ");
		System.out.println("The values being tested are: a shuffled deck of cards");
		System.out.println("The expected results are: a shuffled deck of cards");
		System.out.println("The actual results are: ");
		deck.shuffle();
		System.out.println(deck.toString());
		System.out.println(" ");

		System.out.println("Testing the deal method on the created Deck deck");
		System.out.println("The values being tested are: the top card of the deck");
		System.out.println("The expected results are: the top card of the deck");
		System.out.println("The actual results are: ");
		System.out.println(deck.deal());
		System.out.println(" ");

		System.out.println("Testing the size method on created Deck deck ");
		System.out.println("The values being tested are: the size of the deck");
		System.out.println("The expected results are: 51");
		System.out.println("The actual results are: ");
		System.out.println(deck.size());
		System.out.println(" ");


		}

}
