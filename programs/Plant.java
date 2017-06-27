import java.util.ArrayList;

/**
*
* This class holds the properties for each plant
* @author Luis Lopez
* @author Louie Rivera
* @version 1.0
* @since 2017-06-26
*
*
*/
public class Plant {
    private Map map;
    private int[] pos;

	private String name;
	private int cost;
	private double regenRate;
	private double damage;
	private double health;
	private int range;
	private double dDamage;
	private double speed;

    private static String[] nameList = {"Sunflower", "Peashooter"};
    private static int[] costList = {50, 100};
	
	/**
	* This constructor initiates a plant and gives its position
	*
	* @param n The type of plant
	* @param m The level map
	* @param r The row where the plant will be placed
	* @param c The column where the plance will be placed
	*
	*/
	public Plant (String n, Map m, int r, int c) {
        switch (n) {
            case "Sunflower":
                map = m;
                pos = new int[2];
                pos[0] = r;
                pos[1] = c;

                name = n;
                cost = 50;
                regenRate = 7.5;
                damage = 0;
                health = 30;

                break;
            case "Peashooter":
                map = m;
                pos = new int[2];
                pos[0] = r;
                pos[1] = c;

                name = n;
                cost = 100;
                regenRate = 7.5;
                damage = 7;
                health = 30;
                range = map.getXmax() - 1;
                dDamage = 7;
                speed = 3;

                break;
            default:
                name = null;
                break;
        }
    }
	/**
	*
	* This method returns the position of the plant
	*
	* @return pos The position of the plant
	*
	*/
    public int[] getPos () {
        return pos;
    }
	
	 public String getName () {
        return name;
    }

	/**
	*
	* This method returns the cost of the plant
	*
	* @return cost The cost of the plant
	*
	*/
    public int getCost () {
        return cost;
    }

	/**
	*
	* This method returns the plants
	*
	* @return nameList The names of plants
	*
	*/
    public static String[] getNameList () {
        return nameList;
    }

	/**
	*
	* This method returns the costs
	*
	* @return costList The costs of Plants
	*
	*/
    public static int[] getCostList () {
        return costList;
    }

	/**
	*
	* This method checks if you can afford a plant
	*
	* @param p The player
	* @return list The plants
	*
	*/
    public static ArrayList<String> getNameListAfford (Player p) {
        ArrayList<String> list = new ArrayList<String> ();
        int i;

        for (i = 0 ; i < nameList.length ; i++) {
            if (p.getSun() >= costList[i])
                list.add(nameList[i]);
        }

        return list;
    }
	/**
	*
	* This method displays the plants you can afford
	* @param p The player
	*
	*/
	public static void displayNameListAfford (Player p) {
        ArrayList<String> list = getNameListAfford(p);
        if (!list.isEmpty()) {
            System.out.println("Can afford: ");
            for (String s : nameList)
                System.out.println(s);
            System.out.println("");
        }
        else
            System.out.println("Can't afford any plants!");
    }
	
	/**
	*
	* This method attacks a zombie
	*/
    public void attack () {
        int i;
        Zombie z;
        if (damage > 0) {
            i = 1;
            z = null;
            while (i+pos[1] <= range && z == null) {
                if (map.getZA()[pos[0]][pos[1]+i] != null)
                    z = map.getZA()[pos[0]][pos[1]+i];
                if (z == null);
                    i++;
            }
            if (i == 1)
                z.takeDamage(dDamage);
            else if (i+pos[1] <= range)
                z.takeDamage(damage);
        }
    }
	
	/**
	*
	* This method takes damage from a zombie
	*
	* @param d The amount of damage
	*
	*/
    public void takeDamage (double d) {
        health = health - d;
        if (health <= 0)
            this.kill();
    }
	/**
	*
	* This method kills the plant
	*
	*/
    public void kill () {
        System.out.println("Plant at (" + pos[0] + "," + pos[1] + ") died!");
        map.getPA()[pos[0]][pos[1]] = null;
    }

}
