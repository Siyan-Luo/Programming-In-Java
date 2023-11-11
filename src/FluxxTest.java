//package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Test class, check the Fluxx Game works well 
 */

public class FluxxTest {		
	
	private static final int INITIAL_NUMBER_OF_CARDS = 3;
	
	/**
	 * Runs the game
	 * @param args default parameter
	 */
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("------------------------------------------------------------");
		System.out.println("---------------------------Fluxx Game-----------------------");
		System.out.println("------------------------------------------------------------");
		System.out.println("Welcome to Fluxx!");
		System.out.println("Fluxx is a card game in which the cards themselves determine\r\n"
				+"the current rules of the game. By playing cards, you change\r\n"
				+"numerous aspects of the game: how to draw cards, how to play\r\n"
				+"cards, and even how to win.");
		System.out.println("Rule: "
				+"At the start of the game, each player holds three cards\r\n"
				+ "and on a turn a player draws one card, then plays one card.\r\n"
				+ "By playing cards, you can put new rules into play that change\r\n"
				+ "numerous aspects of the game: how many cards to draw or play,\r\n"
				+ "how many cards you can hold in hand or keep on the table in\r\n "
				+ "front of you, and (most importantly) how to win the game.");
//		initialize a new game
		Game aNewGame = new Game();
		aNewGame.initializePlayers();
		aNewGame.initializeDeck();
		aNewGame.shuffle(aNewGame.getDeck());
//		At the start of the game, each player holds three cards
		for(int i=0;i<aNewGame.getPlayers().size();i++) {
			aNewGame.draw(aNewGame.getPlayers().get(i),FluxxTest.INITIAL_NUMBER_OF_CARDS);
		}
		while (aNewGame.checkGoal()==null) {
//			Loops Through the Players
			for(int i=0;i<aNewGame.getPlayers().size();i++) { 
				System.out.println("----------------------------------------------------");
				Player currentPlayer = aNewGame.getPlayers().get(i);
				System.out.println("It's "+currentPlayer.getName()+"'s turn");
				aNewGame.draw(currentPlayer, aNewGame.getCurrentDrawLimit().getRuleValue());
				String winner = aNewGame.play(currentPlayer, 0);
				if (winner == null) {
//					continue the for loop
					continue;
				}else {
					System.out.print("Congratulations! "+winner+" wins the game!");
//					break the for loop, end the game
					break;
				}
			}
		}

	}			
}

