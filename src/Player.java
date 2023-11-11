//package src;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
/**
 * Player is the class which define all the information that one player needed.
 * <p>
 * player information includes:
 * <ul>
 * <li>The name
 * <li>The hand 
 * <li>The playedKeepers
 * </ul>
 * <p>
 * The hand is a list of {@code card} that hold in player's hand
 * The playedKeepers is a list of {@code keeper} that the player played on the table
 */

public class Player {
	private String name;
	private List<Card> hand;
	private List<Keeper> playedKeepers;
	/**
	 * constructor
	 * @param name player's name
	 * 
	 */
	public Player(String name) {
		this.name=name;
		hand=new ArrayList<Card>();
		playedKeepers= new ArrayList<Keeper>();
	}
	/**
	 * Remove one card from player's hand list.
	 * @param n is the index of this card in hand list
	 */
	public void removeCard(int n) {
		this.hand.remove(n);
	}
	/**
	 * Remove one keeper from player's playedKeeepers list.
	 * @param n is the index of this keeper in hand list
	 */
	
	public void removeKeeper(int n) {
		this.playedKeepers.remove(n);
	}
	/**
	 * Draw one card from the deck then add to the player's hand list.
	 * @param card is the card that player draw from the deck
	 */
	
	public void  drawCard(Card card) {
		hand.add(card);
	}
	/**
	 * Add one keeper to the player's playedKeepers list.
	 * @param keeper is the keeper that player need to add to the playedKeepers list
	 */
	
	public void addKeeper(Keeper keeper) {
		playedKeepers.add(keeper);
	}
	/**
	 * Get the name of this player.
	 * @return name is the name of this player
	 */
	
	public String getName() {
		return name;
	}
	/**
	 * Set the name of this player.
	 * @param name is the name of this player
	 */

	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Get the hand list for this player.
	 * @return hand is the list of card that holds in player's hand
	 */

	public List<Card> getHand() {
		return hand;
	}
	/**
	 * Get the playedKeepers list for this player.
	 * @return playedKeepers is the list of keeper that the player played on the table
	 */

	public List<Keeper> getPlayedKeepers() {
		return playedKeepers;
	}
	/**
	 * Prints the keepers that player played on the table.
	 */

	public void printPlayedKeepers() {
		for (int i=0;i<this.playedKeepers.size();i++) {
			System.out.println(this.playedKeepers.get(i).getCardName());
		}
	}
	/**
	 * Prints the cards that player holds in the hand.
	 */
	
	public void printHand() {
		for (int i=0;i<this.hand.size();i++) {
			System.out.println(this.hand.get(i).getCardName());
		}
	}
}
