public class Plant {
    private Map map;
    private int[] pos;

	private String name;
	private int cost;
	private double regenRate;
	private double damage;
	private double health;
	private ArrayList<Integer[]> range;
	private double dDamage;
	private double speed;
	
	public Plant (String n, Map m, int r, int c) {
        switch (n) {
            case "Sunflower":
                map = m;
                pos = {r,c};

                name = n;
                cost = 50;
                regenRate = 7.5;
                damage = 0;
                health = 30;

                break;
            case "Peashooter":
                map = m;
                pos = {r,c};

                name = n;
                cost = 100;
                regenRate = 7.5;
                damage = 1;
                health = 30;
                range = new ArrayList<Integer[]> ();
                for (int i = 0 ; i < 9 ; i++)
                    range.add({[r+i,c});

                break;
            default:
                name = null;
                break;
        }
    }
	
}
