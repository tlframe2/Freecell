package freecell_framewell;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ConsoleGame {
	
	Player player;
	Table table;
	Scanner scnr;

	public ConsoleGame() {
		player = new Player();
		table = new Table();
		scnr = new Scanner(System.in);
		startGame();
	}
	
	public void startGame() {
		
		char runAgain = 'y';
		char sourceType = ' ';
		char destinationType = ' ';
		int sourceIndex = -1;
		int cardIndex = -1;
		int destinationIndex = -1;
		
		System.out.println("Welcome to FreeCell");
		
		while (!table.hasWon() && runAgain == 'y') {
			
			runAgain = ' ';
			
			table.printTable();
			
			System.out.println("Choose a source type: t = tableau, f = foundation, c = freecell");
			
			sourceType = scnr.next().charAt(0);
			
			if (sourceType == 't') {
				while (sourceIndex < 0 || sourceIndex > 7) {
					System.out.println("Choose a source tableau (0-7): ");
					sourceIndex = scnr.nextInt();
				}
				
				Tableau sourceTab = table.getTableau(sourceIndex);
				
				while (cardIndex < 0 || cardIndex > sourceTab.getSize() - 1) {
					System.out.println("Choose starting index for cards to move starting from the bottom (0 = bottom, size - 1 = top)");
					cardIndex = scnr.nextInt();
				}
				
				if (sourceTab.canBeRemoved(cardIndex)) {
					System.out.println("Choose a destination type: t = tableau, f = foundation, c = freecell");
					destinationType = scnr.next().charAt(0);
					
					if (destinationType == 't') {
						while (destinationIndex < 0 || destinationIndex > 7) {
							System.out.println("Choose a destination tableau (0-7): ");
							destinationIndex = scnr.nextInt();
						}
						
						Tableau destTab = table.getTableau(destinationIndex);
						
						player.moveCards(sourceTab, destTab, cardIndex);
						
					} else if (destinationType == 'f') {
						while (destinationIndex < 0 || destinationIndex > 7) {
							System.out.println("Choose a destination foundation (0-3): ");
							destinationIndex = scnr.nextInt();
						}
						
						Foundation destFound = table.getFoundation(destinationIndex);
						
						player.moveCards(sourceTab, destFound, cardIndex);
						
					} else if (destinationType == 'c') {
						while (destinationIndex < 0 || destinationIndex > 7) {
							System.out.println("Choose a destination freecell (0-3): ");
							destinationIndex = scnr.nextInt();
						}
						
						Freecell destFreecell = table.getFreecell(destinationIndex);
						
						player.moveCards(sourceTab, destFreecell, cardIndex);
						
					} // end destination t if
					
				} else {
					System.out.println("Cards can't be removed from source tableau, chief");
				} // end can be removed if
				
			} 
			
			else if (sourceType == 'f') {
				
				
				
			}// end source t if
			
			while (runAgain != 'y' && runAgain != 'n') {
				System.out.print("Continue? (y for yes or n for no) ");
				runAgain = scnr.next().charAt(0);
			}
			
			sourceType = destinationType = ' ';
			sourceIndex = cardIndex = destinationIndex = -1;
			
			System.out.println();
			
		} // endwhile
	}
}
