public class Plant {

	private String name;
	private int cost;
	private double regenRate;
	private double damage;
	private double health;
	private double range;
	private double dDamage;
	private double speed;
	
	public Plant (String n) {
        switch (n) {
            case "Sunflower":
                name = n;
                cost = 50;
                regenRate = 7.5;
                damage = 0;
        }
    }
	
}
