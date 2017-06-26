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
                damage = 1;
                health = 30;
                range = 8;

                break;
            default:
                name = null;
                break;
        }
    }
	
    public int[] getPos () {
        return pos;
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
