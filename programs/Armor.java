/**
 *
 * This is an Armor class that assigns
 * an armor to the zombie
 *
 * @author Luis Lopez
 * @author Louie Rivera
 * @version 1.0
 * @since 2017-06-26
 */

public class Armor{
	private String name;
	private double damageDec;
	private double speedDec;
	private double healthInc;
	
	/*public Armor()
	{
		name="none";
		damageDec=0;
		speedDec=0;
		healthInc=0;
	}*/
	
	/**
	* This constructor assigns the appropriate armor and
	* status modification to the zombie
	* @param n This is the type of armor
	*/
	public Armor (String n)
	{
        switch (n) {
            case "Flag":
                name = n;
                damageDec = 1;
                speedDec = 0;
                healthInc = 0;
                break;
            case "Cone":
                name = n;
                damageDec = 2;
                speedDec = 2;
                healthInc = 17.75;
                break;
            default:
                name = null;
                break;
        }
	}
	
	/**
	* This method assigns the armor name
	* @param n This is the name of armor
	*/
	public void setName(String n) { name = n; }
	
	/**
	* This method returns the armor name
	* @return name This returns the name of the armor
	*/
	public String getName() { return name; }
	
	/**
	* This method assigns the damage effect of armor
	* @param d This is the damage effect of armor
	*/
	public void setDamageDec(double d) { damageDec = d; }
	
	/**
	* This method returns the damage effect of armor
	* @return damageDec This returns the damage effect of armor
	*/
	public double getDamageDec() { return damageDec; }
	
	/**
	* This method assigns the speed effect of armor
	* @param s This is the speed effect of armor
	*/
	public void setSpeedDec(double s) { speedDec = s; }
	
	/**
	* This method returns the speed effect of armor
	* @return speedDec This returns the speed effect of armor
	*/
	public double getSpeedDec() { return speedDec;}
	
	/**
	* This method assigns the health effect of armor
	* @param h This is the health effect of armor
	*/
	public void setHealthInc(double h) { healthInc = h; }
	
	/**
	* This method returns the health effect of armor
	* @return healthInc This returns the health effect of armor
	*/
	public double getHealthInc() { return healthInc;}

	/**
	* This method modifies the health of the armor
	* when taking damage
	* @param d The amount of damage absorbed
	*/
    public double takeDamage (double d) {
        if (healthInc >= d) {
            healthInc = healthInc - d;
            d = 0;
        }
        else {
            d = d - healthInc;
            healthInc = 0;
        }
        return d;
    }
}
