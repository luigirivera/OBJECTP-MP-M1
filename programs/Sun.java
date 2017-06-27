/**
* This class is for the sun object
* @author Louie Rivera
* @version 1.0
* @since 2017-06-24
*
*/

public class Sun{
    private int amount;
  
	/*
	*
	* This constructor initiates the sun to it's only amount
	* per sun
	*/
    private Sun () {
        amount = 25;
    }
	
	/**
	* This method returns the amount of sun
	* @return amount The amount of sun
	*/

    public int getAmount () {
        return amount;
    }
}
