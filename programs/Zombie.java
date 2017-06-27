/**
*
* This class has the properties of each zombie. It changes everytime
* something happens to a zombie
*
* @author Luis Lopez
* @author Louie Rivera
* @version 1.0
* @since 2017-06-26
*
*/

public class Zombie {
    private Map map;
    private int[] pos;

	private double speed;
	private double health;
	private double damage;
	private Armor armor;
	
	/**
	*
	* This constructor is called when the zombie has no armor
	*
	* @param m The stage map
	* @param r The row of position
	* @param c The column of position
	*
	*/
	public Zombie (Map m, int r, int c) {
        map = m;
        pos = new int[2];
        pos[0] = r;
        pos[1] = c;

		armor = null;
		speed = 4;
		damage = 10;
		health = 70;
	}

	/**
	*
	* This constructor is called when the zombie has an armor
	*
	* @param a The name of the armor
	* @param m The stage map
	* @param r The row of position
	* @param c The column of position
	*
	*/
    public Zombie (String a, Map m, int r, int c) {
        map = m;
        pos = new int[2];
        pos[0] = r;
        pos[1] = c;

        setArmor(new Armor(a));
        speed = 4;
        damage = 10;
        health = 70;
    }

	/**
	*
	* This method returns the position of the zombie
	*
	* @return pos The coordinates of the zombie
	*
	*/
    public int[] getPos () {
        return pos;
    }

	/**
	*
	* This method returns the speed of the zombie
	*
	* @return speed The speed of the zombie
	*
	*/
    public double getSpeed () {
        if (armor != null)
            return speed - armor.getSpeedDec();
        return speed;
    }

	/**
	*
	* This method returns the health of the zombie
	*
	* @return health The health of the zombie
	*
	*/
    public double getHealth () {
        if (armor != null)
            return health + armor.getHealthInc();
        return health;
    }

	/**
	*
	* This method returns the damage impact of the zombie
	*
	* @return damage The damage impact of the zombie
	*
	*/
    public double getDamage () {
        if (armor != null)
            return damage - armor.getDamageDec();
        return damage;
    }

	/**
	*
	* This method returns the armor of the zombie
	*
	* @return armor The armor of the zombie
	*
	*/
    public Armor getArmor () {
        return armor;
    }

    /*	
	public void toFlag() {
		armor = new Armor("Flag");
		//speed=4-armor.getSpeedDec();
		//damage=10-armor.getDamageDec();
		//health=70+armor.getHealthInc();
	}
	
	public void toCone() {
		armor = new Armor("Cone");
		//speed-=armor.getSpeedDec();
		//damage-=armor.getDamageDec();
		//health+=armor.getHealthInc();
	}
    */
	/**
	*
	* This method sets the armor of the zombie
	*
	* @param a The armor of the zombie
	*
	*/
    public void setArmor (Armor a) {
        if (a.getName() != null)
            armor = a;
        else
            armor = null;
    }
	
	/**
	*
	* This method returns if a zombie is beside a plant or not
	*
	* @param p A plant
	* @return true If the zombie is beside a plant
	* @return false if the zombie is not beside a plant
	*
	*/
    public boolean isRightOf (Plant p) {
        return pos[0] == p.getPos()[0] + 1 && pos[1] == p.getPos()[1];
    }

	/**
	*
	* This method returns if a zombie is able to move left
	*
	* @return true If the zombie can move left
	* @return false If the zombie can't move left
	*
	*/
    public boolean moveLeft () {
        int row = pos[0];
        int col = pos[1];
        if (col - 1 >= 0 && map.getPA()[row][col-1] == null && map.getZA()[row][col-1] == null) {
            map.getZA()[row][col-1] = this;
            pos[1] = col-1;
            map.getZA()[row][col] = null;
        }
        else if (col - 1 == -1)
            return true;
        return false;
    }
	
	/**
	*
	* This method decreases the health of the plant
	*
	* @param p The plant that will be affected
	*
	*/
    public void attack (Plant p) {
        if (this.isRightOf(p))
            p.takeDamage(damage);
    }

	/**
	*
	* This method decreases the health of the zombie
	*
	* @param d The amount of damage it will take
	*
	*/
    public void takeDamage (double d) {
        if (armor != null) {
            d = armor.takeDamage(d); 
            if (armor.getHealthInc() <= 0)
                armor = null;
        }
        health = health - d;
        if (this.getHealth() <= 0)
            this.kill();
    }

	/**
	*
	* This method kills the zombie
	*
	*/
    public void kill () {
        System.out.println("Zombie at (" + pos[0] + "," + pos[1] + ") died!");
        map.getZA()[pos[0]][pos[1]] = null;
    }
}
