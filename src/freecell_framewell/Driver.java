package freecell_framewell;

public class Driver {

	public static void main(String[] args) {
		
		Table testTable = new Table();
		Player testPlayer = new Player();
		
		testTable.printTable();
		testPlayer.moveCards(testTable.getTableau(0), testTable.getFreecell(0), 6);
		testTable.printTable();
		testPlayer.moveCards(testTable.getTableau(0), testTable.getFreecell(0), 5);

	}

}
