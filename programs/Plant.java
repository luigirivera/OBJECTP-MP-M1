public class Plant {

	private String name;
    private int[] pos;
	private int cost;
	private double regenRate;
	private double damage;
	private double health;
	private int[][] range;
	private double dDamage;
	private double speed;
	
	public Plant (String n, int A[]) {
        switch (n) {
            case "Sunflower":
                name = n;
                pos = A;
                cost = 50;
                regenRate = 7.5;
                damage = 0;
                health = 30;
            case "Peashooter":
                name = n;
                pos = A;
                cost = 100;
                regenRate = 7.5;
                damage = 1;
                health = 30;
                range = new int[9][2];
                for (int i = 0 ; i < 9 ; i++)
                    range[i] = {[A[0]+i,A[1]}
        }
    }
	
}
