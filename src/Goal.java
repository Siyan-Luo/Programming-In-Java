//package src;
import java.util.ArrayList;
import java.util.List;
/**
 * Goal is a subclass extends from base class {@code Card} and defines unique information that goal card needed.
 * We use ID to distinguish Goal with other cards ,50-100 are goal cards
 * <p>
 * unique information includes:
 * <ul>
 * <li>The goalKeepers
 * </ul>
 * goalKeepers is a list combination of the goal's targeted keepers'id 
 * 
 */

public class Goal extends Card {
	private List<Integer> goalKeepers;
	/**
	 * constructor
	 * @param ID card ID
	 * @param cardName card name
	 * @param content content of the card
	 * @param goalKeepers is the list combination of the goal's targeted keepers'id
	 */
	 

	public Goal(int ID, String cardName, String content,List<Integer> goalKeepers) {
		super(ID, cardName, content);
//		goalKeepers= new ArrayList<Integer>();
		this.goalKeepers = goalKeepers;
	}
	/**
	 * Get the goalKeepers for this goal.
	 * @return goalKeepers is the list combination of the keepers'id
	 */

	public List<Integer> getGoalKeepers() {
		return goalKeepers;
	}
}
