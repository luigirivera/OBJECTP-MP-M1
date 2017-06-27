import java.util.ArrayList;

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
	
    public int[] getPos () {
        return pos;
    }

    public String getName () {
        return name;
    }

    public int getCost () {
        return cost;
    }

    public static String[] getNameList () {
        return nameList;
    }

    public static int[] getCostList () {
        return costList;
    }

    public static ArrayList<String> getNameListAfford (Player p) {
        ArrayList<String> list = new ArrayList<String> ();
        int i;

        for (i = 0 ; i < nameList.length ; i++) {
            if (p.getSun() >= costList[i])
                list.add(nameList[i]);
        }

        return list;
    }

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

    public void takeDamage (double d) {
        health = health - d;
        if (health <= 0)
            this.kill();
    }

    public void kill () {
        System.out.println("Plant at (" + pos[0] + "," + pos[1] + ") died!");
        map.getPA()[pos[0]][pos[1]] = null;
    }

}
