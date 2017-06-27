/**
* This player class holds the information of the player
* @author Luis Lopez
* @version 1.0
* @since 2017-06-26
*/

public class Player {
    private int sun;

	/**
	* This constructor defaults the player sun count to zero
	*/
    public Player () {
        sun = 0;
    }
	
	/**
	* This method returns the sun count the
	* player has currently
	* @return sun The sun count
	*/
	
    public int getSun () {
        return sun;
    }
	
	/**
	* This method adds the new sun to the player's
	* current sun count
	* @param s The sun to be added
	*/
    public void addSun (int s) {
        sun = sun + s;
    }
	
	/**
	* This method wil buy a plant if you have the appropriate
	* sun count
	* @param p The plant to buy
	* @return true If you are able to buy the plant
	* @return false If you are not able to buy the plant
	*/
    public boolean buy (Plant p) {
        if (sun >= p.getCost()) {
            sun = sun - p.getCost();
            return true;
        }
        else
            return false;
    }
}
