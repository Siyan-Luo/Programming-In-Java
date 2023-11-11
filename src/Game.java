//package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.Collections;
/**
 * Provides all the function that the Fluxx Game needed.
 * <p>
 * main function includes:
 * <ul>
 * <li>initializeDeck
 * <li>addPlayer
 * <li>initializaPlayers
 * <li>shuffle
 * <li>discardHand
 * <li>discardKeeper
 * <li>draw
 * <li>play
 * <li>checkGoal
 * <li>userInput
 * <li>help
 * </ul>
 * <p>
 * Game information includes:
 * <ul>
 * <li>players
 * <li>deck
 * <li>discards
 * <li>rulesList
 * <li>goalList
 * <li>currentHandLimit
 * <li>currentGoal
 * <li>currentKeeperLimit
 * <li>currentPlayLimit
 * <li>currentDrawLimit
 * </ul>
 * 
 */


public class Game {
//	the use of global variables to avoid magic numbers
	private static final int INITIAL_NUMBER_OF_DRAWLIMIT = 1;
	private static final int INITIAL_NUMBER_OF_PLAYLIMIT = 1;
//	for the rule "play all" we set the corresponding Rule card's ruleValue to a large number 100 to identify it.
	private static final int NUMBER_OF_PLAYALL = 100;
//	for the initialization of play limit and draw limit rule, we set the id to 0, which has no practical meaning
	private static final int INITIAL_ID = 0;
//	the list of players
	private List<Player> players;
//	the list of deck card
	private List<Card> deck;
//	the list of discard cards
	private List<Card> discards;
//	the list of played rules
	private List<Rule> rulesList;
//	the list of played goals
	private List<Goal> goalsList;
//	current hand limit rule, its value indicates the number of cards the player can hold in hand at the end of their turn
	private Rule currentHandLimit;
//	current goal
	private Card currentGoal;
//	current keeper limit rule, its value indicates the number of keepers the player can display on the table at the end of their turn
	private Rule currentKeeperLimit;
//	current play limit rule, its value indicates the number of cards the player plays in each turn
	private Rule currentPlayLimit;
//	current draw limit rule, its value indicates the number of cards the player draws in each turn
	private Rule currentDrawLimit;
	/**
	 * constructor
	 * 
	 */
	
	public 	Game() {
		players = new ArrayList<Player>();
		deck = new ArrayList<Card>();
		rulesList =new ArrayList<Rule>();
		goalsList = new ArrayList<Goal>();
		discards = new ArrayList<Card>();
//		initialize currentHandLimit to null
		this.currentHandLimit = null;
//		initialize currentGoal to null
		this.currentGoal = null;
//		initialize currentKeeperLimit to null
		this.currentKeeperLimit = null;
//		initialize currentPlayLimit to the limitation of 1
		Rule initPlayLimit = new Rule(INITIAL_ID, null, null, INITIAL_NUMBER_OF_PLAYLIMIT);
		this.currentPlayLimit = initPlayLimit;
//		initialize currentDrawLimit to the limitation of 1
		Rule initDrawLimit = new Rule(INITIAL_ID, null, null, INITIAL_NUMBER_OF_DRAWLIMIT);
		this.currentDrawLimit=initDrawLimit;
	}
	/**
	 * Initializes all the cards and add them into deck.
	 */
	public void initializeDeck() {
	Keeper keeper1 = new Keeper(1,"Keeper: Dreams","To play this card,place it face up on the table in front of you");	
	Keeper keeper2 = new Keeper(2,"Keeper:The Sun","To play this card,place it face up on the table in front of you");	
	Keeper keeper3 = new Keeper(3,"Keeper: The Moon","To play this card,place it face up on the table in front of you");	
	Keeper keeper4 = new Keeper(4,"Keeper: Peace","To play this card,place it face up on the table in front of you");	
	Keeper keeper5 = new Keeper(5,"Keeper: Television","To play this card,place it face up on the table in front of you");	
	Keeper keeper6 = new Keeper(6,"Keeper: Chocolate","To play this card,place it face up on the table in front of you");	
	Keeper keeper7 = new Keeper(7,"Keeper: Cookies","To play this card,place it face up on the table in front of you");	
	Keeper keeper8 = new Keeper(8,"Keeper: Time","To play this card,place it face up on the table in front of you");	
	Keeper keeper9 = new Keeper(9,"Keeper:Love","To play this card,place it face up on the table in front of you");	
	Keeper keeper10 = new Keeper(10,"Keeper: Sleep","To play this card,place it face up on the table in front of you");	
	Keeper keeper11 = new Keeper(11,"Keeper: Bread","To play this card,place it face up on the table in front of you");	
	Keeper keeper12 = new Keeper(12,"Keeper: Money","To play this card,place it face up on the table in front of you");	
	Keeper keeper13 = new Keeper(13,"Keeper: Milk","To play this card,place it face up on the table in front of you");
	Keeper keeper14 = new Keeper(14,"Keeper: The Rocket","To play this card,place it face up on the table in front of you");	
	Keeper keeper15 = new Keeper(15,"Keeper: War","To play this card,place it face up on the table in front of you");	
	Keeper keeper16 = new Keeper(16,"Keeper: Death","To play this card,place it face up on the table in front of you");	
	Keeper keeper17 = new Keeper(17,"Keeper: The Brain","To play this card,place it face up on the table in front of you");	
	Keeper keeper18 = new Keeper(18,"Keeper: The Toaster","To play this card,place it face up on the table in front of you");	
	List<Integer> goalKeepers1 = new ArrayList<Integer>(Arrays.asList(8,12));
	Goal goal1 = new Goal(51,"Goal: Time is Money","The player with Time and Money on the table wins. ", goalKeepers1);
	List<Integer> goalKeepers2 = new ArrayList<Integer>(Arrays.asList(6,13));
	Goal goal2 = new Goal(52,"Goal: Chocolate Milk","The player with Chocolate and Milk on the table wins. ", goalKeepers2);
	List<Integer> goalKeepers3 = new ArrayList<Integer>(Arrays.asList(9));
	Goal goal3 = new Goal(53,"Goal: All You Need is Love","The player who has Love on the table wins.but only if that player has no other Keepers on the table . ", goalKeepers3);
	List<Integer> goalKeepers4 = new ArrayList<Integer>(Arrays.asList(13,7));
	Goal goal4 = new Goal(54,"Goal: Milk and Cookies","The player with Milk and Cookies on the table wins. ", goalKeepers4);
	List<Integer> goalKeepers5 = new ArrayList<Integer>(Arrays.asList(6,7));
	Goal goal5 = new Goal(55,"Goal: Chocolate Cookies","The player with Chocolate and Cookies on the table wins.", goalKeepers5);
	List<Integer> goalKeepers6 = new ArrayList<Integer>(Arrays.asList(4));
	Goal goal6 = new Goal(56,"Goal: Peace(No War)","If no one has War on the table,then the player with Peace on the table wins. ", goalKeepers6);
	List<Integer> goalKeepers7 = new ArrayList<Integer>(Arrays.asList(4,9));
	Goal goal7 = new Goal(57,"Goal: Hippyism","The player with Peace and Love on the table wins. ", goalKeepers7);
	List<Integer> goalKeepers8 = new ArrayList<Integer>(Arrays.asList(10,1));
	Goal goal8 = new Goal(58,"Goal: Dreamland","The player with Sleep and Dream on the table wins. ", goalKeepers8);
	List<Integer> goalKeepers9 = new ArrayList<Integer>(Arrays.asList(15,16));
	Goal goal9 = new Goal(59,"Goal: War = Death","The player with War and Death on the table wins. ", goalKeepers9);
	List<Integer> goalKeepers10 = new ArrayList<Integer>(Arrays.asList(10,8));
	Goal goal10 = new Goal(60,"Goal: Bed Time","The player with Sleep and Time on the table wins. ", goalKeepers10);
	List<Integer> goalKeepers11 = new ArrayList<Integer>(Arrays.asList(14,3));
	Goal goal11 = new Goal(61,"Goal: Rocket to the Moon","The player with Rocket and Moon on the table wins. ", goalKeepers11);
	List<Integer> goalKeepers12 = new ArrayList<Integer>(Arrays.asList(9,17));
	Goal goal12 = new Goal(62,"Goal: Hearts and Minds","The player with Love and The Brain on the table wins. ", goalKeepers12);
	List<Integer> goalKeepers13 = new ArrayList<Integer>(Arrays.asList(3,2));
	Goal goal13 = new Goal(63,"Goal: Night and Day","The player with Moon and Sun on the table wins. ", goalKeepers13);
	List<Integer> goalKeepers14 = new ArrayList<Integer>(Arrays.asList(1,12));
	Goal goal14 = new Goal(64,"Goal: Winning the Lottery","The player with Dreams and Money on the table wins. ", goalKeepers14);
	List<Integer> goalKeepers15 = new ArrayList<Integer>(Arrays.asList(5,18));
	Goal goal15 = new Goal(65,"Goal: The  Appliances","The player with Television and Toaster on the table wins. ", goalKeepers15);
	List<Integer> goalKeepers16 = new ArrayList<Integer>(Arrays.asList(17));
	Goal goal16 = new Goal(66,"Goal: The Brain(No TV)","If no one has Television on the table,then the player with Brain on the table wins. ", goalKeepers16);
	List<Integer> goalKeepers17 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0,0));
	Goal goal17 = new Goal(67,"Goal: 10 Cards in Hand","If someone has 10 or more cards in his or her hand,then the player with the most cards in hand wins.(In the events of a tie,continue playing until a clear winner emerges.) ", goalKeepers17);
	List<Integer> goalKeepers18 = new ArrayList<Integer>(Arrays.asList(2,6));
	Goal goal18 = new Goal(68,"Goal: Squishy Cholocate","The player with Sun and Cholocate on the table wins. ", goalKeepers18);
	List<Integer> goalKeepers19 = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0));
	Goal goal19 = new Goal(69,"Goal: 5 Keepers","If someone has 5 or more Keepers on the table,then the player with the most Keepers wins.(In the events of a tie,continue playing until a clear winner emerges. ", goalKeepers19);
	List<Integer> goalKeepers20 = new ArrayList<Integer>(Arrays.asList(6,16));
	Goal goal20 = new Goal(70,"Goal: Death by Chocolate","The player with Death and Cholocate on the table wins. ", goalKeepers20);
	List<Integer> goalKeepers21 = new ArrayList<Integer>(Arrays.asList(14,17));
	Goal goal21 = new Goal(71,"Goal: Rocket Science","The player with Rocket and the Brain on the table wins. ", goalKeepers21);
	List<Integer> goalKeepers22 = new ArrayList<Integer>(Arrays.asList(11,7));
	Goal goal22 = new Goal(72,"Goal: Baked Goods","The player with Bread and Cookies on the table wins. ", goalKeepers22);
	List<Integer> goalKeepers23 = new ArrayList<Integer>(Arrays.asList(11,18));
	Goal goal23 = new Goal(73,"Goal: Toast","The player with Bread and Toaster on the table wins. ", goalKeepers23);
	
	Rule rule1 = new Rule(101,"Rule: Hand Limit 0","If isn't your turn ,you cannot hold any cards in your hand.If you have extra cards,discard them immediately. During your turn ,you may ignore the Hand LImit, as long as you discard all  your cards when you end your turn.",0);
	Rule rule2 = new Rule(102,"Rule: Hand Limit 1","If isn't your turn ,you should only have 1 card in your hand.If you have extra cards,discard them immediately.During your turn ,you may ignore the Hand LImit, as long as you discard all but 1 of your cards when you end your turn.",1);
	Rule rule3 = new Rule(103,"Rule: Hand Limit 2","If isn't your turn ,you should only have 2 card in your hand.If you have extra cards,discard them immediately.During your turn ,you may ignore the Hand LImit, as long as you discard all but 2 of your cards when you end your turn.",2);
	
	Rule rule4 = new Rule(121,"Rule: Keeper Limit 2","If isn't your turn ,you should only have 2 Keepers in play.Discard any extras immediately.You may play new Keepers during your turn as long as you discard all but 2 at the end ofyour turn.",2);
	Rule rule5 = new Rule(122,"Rule: Keeper Limit 3","If isn't your turn ,you should only have 3 Keepers in play.Discard any extras immediately.You may play new Keepers during your turn as long as you discard all but 3 at the end ofyour turn.",3);
	Rule rule6 = new Rule(123,"Rule: Keeper Limit 4","If isn't your turn ,you should only have 4 Keepers in play.Discard any extras immediately.You may play new Keepers during your turn as long as you discard all but 4 at the end ofyour turn.",4);
	
	Rule rule7 = new Rule(141,"Rule: Play Limit 2","Play 2 cards per turn. If you have fewer than 2 cards in your hand, play all your cards.",2);
	Rule rule8 = new Rule(142,"Rule: Play Limit 3","Play 3 cards per turn. If you have fewer than 3 cards in your hand, play all your cards.",3);
	Rule rule9 = new Rule(143,"Rule: Play Limit 4","Play 4 cards per turn. If you have fewer than 4 cards in your hand, play all your cards.",4);
	Rule rule10 = new Rule(145,"Rule: Play All","Play all of the cards in your hand each turn. ",NUMBER_OF_PLAYALL);
	
	Rule rule11 = new Rule(161,"Rule: Draw Limit 2","Draw 2 cards per turn. The person who played this card should immediately draw extra cards(if needed) so tht they have drawn 2 cards this turn.",2);
	Rule rule12 = new Rule(162,"Rule: Draw Limit 3","Draw 3 cards per turn. The person who played this card should immediately draw extra cards(if needed) so tht they have drawn 3 cards this turn.",3);
	Rule rule13 = new Rule(163,"Rule: Draw Limit 4","Draw 4 cards per turn. The person who played this card should immediately draw extra cards(if needed) so tht they have drawn 4 cards this turn.",4);
	Rule rule14 = new Rule(164,"Rule: Draw Limit 5","Draw 5 cards per turn. The person who played this card should immediately draw extra cards(if needed) so tht they have drawn 5 cards this turn.",5);
	deck.add(rule14);
	deck.add(rule13);
	deck.add(rule12);
	deck.add(rule11);
	deck.add(rule10);
	deck.add(rule9);
	deck.add(rule8);
	deck.add(rule7);
	deck.add(rule6);
	deck.add(rule5);
	deck.add(rule4);
	deck.add(rule3);
	deck.add(rule2);
	deck.add(rule1);
	deck.add(keeper18);
	deck.add(keeper17);
	deck.add(keeper16);
	deck.add(keeper15);
	deck.add(keeper14);
	deck.add(keeper13);
	deck.add(keeper12);
	deck.add(keeper11);
	deck.add(keeper10);
	deck.add(keeper9);
	deck.add(keeper8);
	deck.add(keeper7);
	deck.add(keeper6);
	deck.add(keeper5);
	deck.add(keeper4);
	deck.add(keeper3);
	deck.add(keeper2);
	deck.add(keeper1);
	deck.add(goal23);
	deck.add(goal22);
	deck.add(goal21);
	deck.add(goal20);
	deck.add(goal19);
	deck.add(goal18);
	deck.add(goal17);
	deck.add(goal16);
	deck.add(goal15);
	deck.add(goal14);
	deck.add(goal13);
	deck.add(goal12);
	deck.add(goal11);
	deck.add(goal10);
	deck.add(goal9);
	deck.add(goal8);
	deck.add(goal7);
	deck.add(goal6);
	deck.add(goal5);
	deck.add(goal4);
	deck.add(goal3);
	deck.add(goal2);
	deck.add(goal1);
	}

	/**
	 * Get the currentHandLimit.
	 * @return currentHandLimit is current handLimit Rule
	 */
	

	public Rule getCurrentHandLimit() {
		return currentHandLimit;
	}
	/**
	 * Set the currentHandLimit.
	 * @param r is the new handLimit Rule card
	 */

	public void setCurrentHandLimit(Rule r) {
		this.currentHandLimit = r;
	}
	/**
	 * Get the currentGoal.
	 * @return currentGoal is the current goal
	 */

	public Card getCurrentGoal() {
		return currentGoal;
	}
	/**
	 * Set the currentGoal.
	 * @param goal is the new goal
	 */

	public void setCurrentGoal(Card goal) {
		this.currentGoal = goal;
	}
	/**
	 * Get the currentKeeperLimit.
	 * @return currentKeeperLimit is the current keeperLimit Rule
	 */

	public Rule getCurrentKeeperLimit() {
		return currentKeeperLimit;
	}
	/**
	 * Set the currentKeeperLimit.
	 * @param r is the new keeperLimit Rule
	 */

	public void setCurrentKeeperLimit(Rule r) {
		this.currentKeeperLimit = r;
	}
	/**
	 * Get the currentPlayLimit.
	 * @return currentPlayLimit is current playLimit Rule
	 */

	public Rule getCurrentPlayLimit() {
		return currentPlayLimit;
	}
	/**
	 * Set the currentPlayLimit.
	 * @param r is the new playLimit Rule
	 */

	public void setCurrentPlayLimit(Rule r) {
		this.currentPlayLimit = r;
	}
	/**
	 * Get the currentDrawLimit.
	 * @return currentDrawLimit is the current drawLimit Rule
	 */
	
	public Rule getCurrentDrawLimit() {
		return this.currentDrawLimit;
	}
	/**
	 * Set the currentDrawLimit.
	 * @param r is the new drawLimit Rule
	 */
	
	public void setCurrentDrawLimit(Rule r) {
		this.currentDrawLimit = r;
	}
	/**
	 * Get the players.
	 * @return players is the list of players
	 */

	public List<Player> getPlayers() {
		return players;
	}
	/**
	 * Get the deck.
	 * @return deck is the list of cards players can draw from
	 */

	public List<Card> getDeck() {
		return deck;
	}
	/**
	 * Get the ruleList.
	 * @return ruleList is the list of played rules
	 */

	public List<Rule> getRulesList() {
		return rulesList;
	}
	/**
	 * Get the goalList.
	 * @return goalList is the of the list of played goals
	 */

	public List<Goal> getGoalsList() {
		return goalsList;
	}
	/**
	 * Add player to the players list
	 * @param player is the player input from the {@code initializePlayers}
	 */
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	/**
	 * Add rule into the rulesList. 
	 * @param rule is the rule card
	 */
	public void addRule(Rule rule) {
		rulesList.add(rule);
	}
	/**
	 * Add goal into goalList.
	 * @param goal is the goal card
	 */
	public void addGoal(Goal goal) {
		goalsList.add(goal);
	}
	
	
	/**
	 * Initialize the players.
	 * set the number of players range from 2 to 6
	 * input every player's name
	 *
	 */
	public void initializePlayers() {
//		error handling, set a boolean value to check the validity of input, initialize it to false
		boolean isValid = false;
		System.out.println("The number of players ranges from 2 to 6.");
		System.out.println("Please enter the number of players:");
//		while loop to verify the input until it's valid
		while(isValid == false) {
			Scanner scan = new Scanner(System.in);
//			try catch statement to guarantee the input is an integer
			try {
				int number = scan.nextInt();
				if(number>=2&&number<=6) {
					isValid = true;
					for(int i=1;i<=number;i++) {
//						initialize player and add to the players list
						System.out.println("Please input player's name:");
						String playerName = scan.next();
						Player player = new Player(playerName);
						addPlayer(player);
					}
				}
			}catch(Exception e) {
				System.out.println("Invalid input! Please enter a number from 2 to 6!");
			}
		}
	}
	
	/**
	 * Shuffle cards.
	 * @param cards is the list of cards
	 */
	
	public void  shuffle(List<Card> cards) {
		Collections.shuffle(cards);
//		set the deck to shuffled cards
		this.deck = cards;
	}
	/**
	 * Discard the card in player's hand, and add it into discards list.
	 * @param player is the current player who is required to discard cards in hand
	 * @param number is the number of the cards needs to discard 
	 */
	
	public void discardHand(Player player,int number) {
		System.out.println("In this turn "+player.getName()+ " has to discard "+number+" card(s)");
		for (int i=0;i<number;i++) {
			System.out.println(player.getHand().size());
//			get the index of chose card
			int n = userInput(player, player.getHand());
//			add the discard to discards list
			discards.add(player.getHand().get(n));
//			remove the discard from player's hand
			player.removeCard(n);
			
		}
	}
	/**
	 * Discard the keeper in player's playedKeeper list and add it into discards list. 
	 * @param player is the current player who is required to discard displayed keepers on the table
	 * @param number is the number of the keepers needs to discard 
	 */
	public void discardKeeper(Player player,int number) {
		System.out.println("In this turn "+player.getName()+ " has to discard "+number+" Keeper(s)");
//		cast keeper to card, otherwise we can't pass the keeper list to userInput method
		List<Card> keeperCards = new ArrayList<Card>();
		for(int i=0;i<player.getPlayedKeepers().size();i++) {
			keeperCards.add((Card) player.getPlayedKeepers().get(i));
		}
		for (int i=0;i<number;i++) {
//			get the index of chose card
			int n = userInput(player, keeperCards);
//			add the discard to discards list
			discards.add(player.getPlayedKeepers().get(n));
//		    remove the discard from player's displayed keeper
			player.removeKeeper(n);
		}
	}
	/**
	 * Draw cards from the deck and remove them from deck, add them to the player's hand
	 * if deck is empty,recycle discards as deck ,if it's still not enough draw all the cards in deck then just play card directly
	 * @param player is the current player who is required to draw cards
	 * @param number is the number of cards that the player needs to draw
	 */
	public void draw(Player player,int number) {
//		if deck is empty, recycle discards as deck
		if (this.deck.size()<number) {
			shuffle(discards);
//			set discards to a new empty list
			this.discards = new ArrayList<Card>();
//			if it's still not enough, draw all the cards in deck
			if (this.deck.size()<number) {
				for(int i=0;i<this.deck.size();i++) {
					player.drawCard(this.deck.get(0));
					this.deck.remove(0);
				}
				System.out.println("Deck is empty now, player plays card directly.");
			}else {
				for (int i=0;i<number;i++){
					player.drawCard(this.deck.get(0));
					this.deck.remove(0);
				}
			}
		}
		else {
			for (int i=0;i<number;i++){
			player.drawCard(this.deck.get(0));
			this.deck.remove(0);}
		}
	}
	/**
	 * Play the card.
	 * player play one card one time
	 * we face 3 situations when the player plays one card
	 * First, play keeper card, we add them into keeper list
	 * Second, play goal card, we add them into goal list and set new currentGoal, add the previous goal to discards
	 * Third, play rule card, set currentRules accordingly, add the previous rule to discards
	 * We used recursion in this method to make sure the player reaches the play limit
	 * @param player is the player who play the game now
	 * @param counter is the number of cards has been played in this turn, used to make sure player reaches the play limit. After player plays a card, counter increases by one.
	 * @return winner, after playing a card we immediately call checkGoal and return winner's name or null which indicates there's no winner yet
	 */
	
	public String play(Player player, int counter) {
		System.out.println("Please play your cards");
//		get the index of chose card
		int n = userInput(player, player.getHand());
		Card select = player.getHand().get(n);
//		get the id of chose card
		int id = select.getID();
//		remove the card from player's hand list
		player.removeCard(n);
//		we identify the type of card by its id
		if (id>0 && id<=50) {
//			keeper
//			add it to player's keeper list
			player.addKeeper((Keeper)select);
		}else if(id>50 && id<=100) {
//			goal
//			if it's not null, add the previous goal to discards
			if (getCurrentGoal()!=null) {
				discards.add(getCurrentGoal());
			}
//			add and set new goal
			addGoal((Goal)select);
			setCurrentGoal(select);
		}else if(id>100 && id<=180) {
//			rule
//			add it the played rule list
			addRule((Rule)select);
//			we identify the type of rule according to its id
			if (id>100 && id<=120) {
//				hand limit
//				if it's not null, add the previous hand limit rule to discards
				if (getCurrentHandLimit()!=null) {
					discards.add(getCurrentHandLimit());
				}
//				set new hand limit
				setCurrentHandLimit((Rule)select);
				System.out.println("Hand Limit Rule has changed.");
				System.out.println("From now on, everyone can only have "+getCurrentHandLimit().getRuleValue()+" card(s) in hand");
//				loop through the players to check if they obey the new rule, otherwise ask them to discard cards
				for (int i=0;i<this.players.size();i++) {
					Player p = this.players.get(i);	
//					expect the current player, everyone else should obey the rule immediately
					if (!p.getName().equals(player.getName())) {
						if (p.getHand().size()>getCurrentHandLimit().getRuleValue()) {
							discardHand(p, p.getHand().size()-getCurrentHandLimit().getRuleValue());
						}
					}
				}
			}else if(id>120 && id<=140) {
//				keeper limit
//				if it's not null, add the previous keeper limit rule to discards
				if (getCurrentKeeperLimit()!=null) {
					discards.add(getCurrentKeeperLimit());
				}
//				set new keeper limit
				setCurrentKeeperLimit((Rule)select);
				System.out.println("Keeper Limit Rule has changed.");
				System.out.println("From now on, everyone can only have "+getCurrentKeeperLimit().getRuleValue()+" keeper(s)");
//				loop through the players to check if they obey the new rule, otherwise ask them to discard keepers
				for (int i=0;i<this.players.size();i++) {
					Player p = this.players.get(i);
//					expect the current player, everyone else should obey the rule immediately
					if (!p.getName().equals(player.getName())) {
						if (p.getPlayedKeepers().size()>getCurrentKeeperLimit().getRuleValue()) {
							discardKeeper(p, p.getPlayedKeepers().size()-getCurrentKeeperLimit().getRuleValue());
						}
					}
				}
			}else if(id>140 && id<=160){
//				play limit
//				if it's not null, add the previous play limit rule to discards
				if (getCurrentPlayLimit().getCardName()!=null) {
					discards.add(getCurrentPlayLimit());
				}
//				set new play limit
				setCurrentPlayLimit((Rule)select);
				System.out.println("Play Limit Rule has changed.");
//				the play limit is play all
				if(getCurrentPlayLimit().getRuleValue()==NUMBER_OF_PLAYALL) {
					System.out.println("From now on, everyone should play all the cards in hand each turn");
					if (getCurrentPlayLimit().getRuleValue()-counter-1>0) {
						System.out.println(player.getName()+" has to play another "+ player.getHand().size()+" card(s)");
					}
				}
				else {
					System.out.println("From now on, everyone should play "+getCurrentPlayLimit().getRuleValue()+" card(s) each turn");
					if (getCurrentPlayLimit().getRuleValue()-counter-1>0) {
						System.out.println(player.getName()+" has to play another "+ (getCurrentPlayLimit().getRuleValue()-counter-1)+" card(s)");
					}
				}
			}else {
//				draw limit
//				if it's not null, add the previous draw limit rule to discards
				if (getCurrentDrawLimit().getCardName()!=null) {
					discards.add(getCurrentDrawLimit());
				}
				System.out.println("Draw Limit Rule has changed.");
				System.out.println("From now on, everyone should draw "+((Rule)select).getRuleValue()+" cards each turn");
//				if the new draw limit is larger than the previous one, let the player draw another cards
				if (((Rule)select).getRuleValue()>getCurrentDrawLimit().getRuleValue()) {
					int NrDraw=((Rule)select).getRuleValue()-getCurrentDrawLimit().getRuleValue();
					System.out.println(player.getName()+" has drawed another "+NrDraw+" card(s)");
					draw(player,NrDraw);
				}
//				set new draw limit
				setCurrentDrawLimit((Rule)select);
			}
		}
//		increase the counter by one
		counter++;
//		check the goal after a card is played
		String winner = checkGoal();
//		if there's no winner 
		if (winner == null) {
//			the player hasn't reached the play limit
			if (getCurrentPlayLimit().getRuleValue()>counter) {
				if(getCurrentPlayLimit().getRuleValue()==NUMBER_OF_PLAYALL) {
//					the play limit is play all
					System.out.println(player.getName()+" has played "+counter+" cards, "+"he/she has to play "
							+ player.getHand().size() +" more card(s)");
				}
				else {
				System.out.println(player.getName()+" has played "+counter+" cards, "+"he/she has to play "
						+ (getCurrentPlayLimit().getRuleValue()-counter) +" more card(s)");
				}
//				there're still cards in hand, continue playing
				if(player.getHand().size()>0) {
					play(player, counter);
//				otherwise, this player's turn ends
				}else {
					System.out.println(player.getName()+" 's hand is empty now.");
				}
			}
		}
		
//  	the player reaches the play limit or has no card in hand, the player's turn ends.
		if (getCurrentPlayLimit().getRuleValue()==counter || player.getHand().size()==0) {
//  	there's no winner
			if (winner == null) {
//				at the end of the turn, check if the number of keepers reaches the limit
				if (getCurrentKeeperLimit()!=null &&
						getCurrentKeeperLimit().getRuleValue()<player.getPlayedKeepers().size()) 
				{
					System.out.println(player.getName()+"'s turn ended, but you have reached the current keeper limit "
						+getCurrentKeeperLimit().getRuleValue());
					discardKeeper(player, player.getPlayedKeepers().size()-getCurrentKeeperLimit().getRuleValue());
				}
//			    at the end of the turn, check if the number of cards in hand reaches the limit
				if (getCurrentHandLimit()!=null &&
						getCurrentHandLimit().getRuleValue()<player.getHand().size()) 
				{
					System.out.println(player.getName()+"'s turn ended, but you have reached the current hand limit "
	    					   +getCurrentHandLimit().getRuleValue());
					discardHand(player, player.getHand().size()-getCurrentHandLimit().getRuleValue());
				}
			}
		}
//		return the winner
		return winner;
	}
	
	/**
	 * Check if the playedKeeper in player's table meets the requirement of the goal or not.
	 * we have 4 types of goal
	 * First,the goal contains 2 keepers, we need to check if the player's playedKeeper contains the 2 keepers
	 * Second, the goal requires player to have more than 5 keepers in the playedKeeper, we check the playedKeeper size
	 * Third, the goal only contains one keeper, at the same time doesn't allow another keeper in all player's playedKeeper
	 * Fourth,the goal requires player to have more than 10 cards in hand, we need to check the player's hand size
	 * @return the name of the winner if there's a winner, otherwise return null
	 */
	public String checkGoal() {
		if(getCurrentGoal()!=null) {
//			loop through every player
			for (int i=0;i<this.players.size();i++){
				List<Keeper> keepers = this.players.get(i).getPlayedKeepers();
				List<Card> hand = this.players.get(i).getHand();
//				create a list of played keepers' id
				List<Integer> keeperIDs = new ArrayList<Integer>();
				for (int j=0;j<keepers.size();j++) {
					keeperIDs.add(keepers.get(j).getID());
				}
//				get the current goal's targeted keepers'id list
				List<Integer> currentGoalKeepers = ((Goal)getCurrentGoal()).getGoalKeepers();
//				the number of targeted keepers'id list
				int NrGoalKeepers = currentGoalKeepers.size();
				if (NrGoalKeepers == 2) {
//					the goal is to have two specific keepers
					if (keeperIDs.contains(currentGoalKeepers.get(0))
						&& keeperIDs.contains(currentGoalKeepers.get(1))) {
						return this.players.get(i).getName();
					}
				}else if(NrGoalKeepers == 5){
//					the goal is 5 keepers
					if (keeperIDs.size()>=5) {
						return this.players.get(i).getName();
					}
				}else if(NrGoalKeepers==10) {
//					the goal is 10 hands
					if(hand.size()>=10) {
						return this.players.get(i).getName();
					}
					
				}
				else if(NrGoalKeepers == 1){
//					only one goal
					if(((Goal) getCurrentGoal()).getID()==51) {
//						all you need is love
						if (keeperIDs.size()==1
							&& keeperIDs.get(0) == (((Goal)getCurrentGoal()).getGoalKeepers().get(0))){
							return this.players.get(i).getName();
						}
					}
					if(((Goal) getCurrentGoal()).getID()==52) {
//						Peace(No war)
//						peace=52 war=53
//						the player has peace keeper
						if (keeperIDs.contains(currentGoalKeepers.get(0))){
//							loop through players to check there's no war 
							for(int j=0;j<players.size();j++) {
								if(players.get(j).getPlayedKeepers().contains(53)) {
									return null;
								}
							}
							return this.players.get(i).getName();
						}
					}
					if(((Goal) getCurrentGoal()).getID()==54) {
//						Brain(No TV)
//						Brain=54 TV=55
//						the player has brain keeper
						if (keeperIDs.contains(currentGoalKeepers.get(0))){
//							loop through players to check there's no TV
							for(int j=0;j<players.size();j++) {
								if(players.get(j).getPlayedKeepers().contains(55)) {
									return null;
								}
							}
							return this.players.get(i).getName();
						}
					}
				}
			}
		}
		return null;
	}
	/**
	 * Get the user input value.
	 * we have 2 types of input
	 * First,try if input a valid number, it gets the index of card that player choose
	 * Second, catch if input a valid string, it gets the help that player needs.
	 * If it's neither two of them throw a invalid waring,then user can input again  
	 * @param player is current player
	 * @param cards is the list of cards the player has to choose from 
	 * @return answer is the card index that player chooses, which is an integer between 0 and X, where X is the total number of cards that be can choose by the user
	 * 
	 */
	public int userInput(Player player, List<Card> cards) {
		Scanner scan = new Scanner(System.in);
//		error handling, set a boolean value to check if the input is valid, initialize it to false
		boolean validInput = false;
//		while loop the check the validity until it's true
		while(validInput==false) {
			try {
//				display the cards of selection with indexes
				int n = cards.size();
				for (int i=0;i<n;i++) {
					System.out.println(""+i+"."+cards.get(i).getCardName());
				}
				System.out.println("----------------------------------------------------");
				System.out.println("Select a card from 0 to "+(n-1)+":");
//				try to input an integer				
				int answer = scan.nextInt();
//				check it's within the range
//				the answer is valid only if the user inputs an integer from 0 to X
//				where X is the total number of cards that be can choose by the user
				if (answer>=0&&answer<n) {
					validInput = true;
					System.out.println(player.getName()+" 's choice:");
					System.out.println(cards.get(answer).getCardName());
					return answer;
				}
				
			}catch(Exception e){
//				catch if the input is a string
				String answer = scan.nextLine();	
//				convert its format to enable tolerance
				answer = answer.toUpperCase().replaceAll("\\s", "");
//				check the answer matches which help option
				if (answer.equals("SHOWKEEPERS")) {
					if(player.getPlayedKeepers().size()==0) {
						System.out.println("You keeper list is empty now");
					}else {
						player.printPlayedKeepers();
					}
					System.out.println("----------------------------------------------------");
				}else if (answer.equals("SHOWHAND")){
					if(player.getHand().size()==0) {
						System.out.println("You hand list is empty now");
					}else {
						player.printHand();
					}
					System.out.println("----------------------------------------------------");
				}else if (answer.equals("SHOWGOALS")) {
					List<Goal> goals = getGoalsList();
					for (int i=0;i<goals.size();i++) {
						System.out.println(goals.get(i).getCardName()+goals.get(i).getContent());
					}
					System.out.println("----------------------------------------------------");
				}else if (answer.equals("SHOWRULES")) {
					List<Rule> rules = getRulesList();
					for (int i=0;i<rules.size();i++) {
						System.out.println(rules.get(i).getCardName()+rules.get(i).getContent());
					}
					System.out.println("----------------------------------------------------");
				}else if (answer.equals("HELP")) {
					help();
				}else {
//					if the string input is not valid, require the player to input again
					System.out.println("Invalid input.");
					System.out.println("Please enter again");
					System.out.println("If you need any help, please enter help");
				}
			}
		}
		return -1;
	}
	
	/**
	 * Help the player to play the game.
	 */
	public void help() {
		System.out.println("There're 5 options for you:");
		System.out.println("----------------------------------------------------");
		System.out.println("Show keepers");
		System.out.println("----------------------------------------------------");
		System.out.println("Show hand");
		System.out.println("----------------------------------------------------");
		System.out.println("Show goals");
		System.out.println("----------------------------------------------------");
		System.out.println("Show rules");
		System.out.println("----------------------------------------------------");
	}
	
	
	
	
	
	
}
