//package src;
/**
 * Card is the abstract base class for all types of cards.
 * <p>
 * A Card object encapsulates the information that all types of cards needed
 * information includes:
 * <ul>
 * <li>The ID
 * <li>The cardName
 * <li>The content
 * </ul>
 * 
 */

public abstract class Card {
	private int ID;
	private String cardName;
	private String content;
/**
 * constructor 
 * @param ID: card ID      
 * @param cardName: card name
 * @param content: content of the card
 */
	public Card(int ID,String cardName,String content) {
		this.ID=ID;
		this.cardName=cardName;
		this.content=content;
	}
	
     /**
	 * Get the ID for this card.
	 * @return ID is the cardID of this card
	 */
	public int getID() {
		return ID;
	}
	/**
	 * Set the ID for this card.
	 * @param id is the cardID of this card
	 */
	public void setID(int id) {
		this.ID = id;
	}
	/**
	 * Get the CardName for this card.
	 * @return cardName is the cardName of this card
	 */
	public String getCardName() {
		return cardName;
	}
	/**
	 * Set the cardName for this card.
	 * @param cardName is the cardName of this card
	 */
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	/**
	 * Get the Content for this card.
	 * @return content is the content of this card
	 */
	public String getContent() {
		return content;
	}
	/**
	 * Set the Content for this card.
	 * @param content is the content of this card
	 */
	public void setContent(String content) {
		this.content = content;
	}
	

}
