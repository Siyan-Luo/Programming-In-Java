//package src;
/**
 * Rule is a subclass extends from base class {@code Card} and defines unique information that rule card needed.
 * Rule have 4 different types, they are hand limit, keeper limit, play limit, draw limit
 * We use ID to distinguish them 101-120 are hand limit cards
 * 121-140 are keeper limit cards, 141-160 are play limit cards, 161-180 are draw limit cards
 * <p>
 * unique information includes:
 * <ul>
 * <li>The ruleValue
 * </ul>
 * ruleValue is an integer which means the number of the cards that the rule defines to operate, in another word, the limitation
 * 
 *
 */

public class Rule extends Card {
	private int ruleValue;

	/**
	 * constructor
	 * @param ID cardID
	 * @param cardName cardName
	 * @param content content of the card
	 * @param ruleValue the number of the cards that the rule define to operate 
	 */
	public Rule(int ID, String cardName, String content,int ruleValue) {
		super(ID, cardName, content);
		this.ruleValue=ruleValue;
		
	}
	/**
	 * Get the ruleValue of this Rule.
	 * @return ruleValue is the number of the cards that the rule define to operate 
	 */

	public int getRuleValue() {
		return ruleValue;
	}
	

}
