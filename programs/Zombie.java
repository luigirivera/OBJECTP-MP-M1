public class Zombie {
    private Map map;
    private int[] pos;

	private double speed;
	private double health;
	private double damage;
	private Armor armor;
	
	public Zombie (Map m, int r, int c) {
        map = m;
        pos = {r,c};

		armor = null
		speed = 4;
		damage = 10;
		health = 70;
	}

    public Zombie (String a, Map m, int r, int c) {
        map = m;
        pos = {r,c};

        setArmor(new Armor(a));
        speed = 4;
        damage = 10;
        health = 70;
    }

    public double getSpeed () {
        if (armor != null)
            return speed - armor.getSpeedDec();
        return speed;
    }

    public double getHealth () {
        if (armor != null)
            return health + armor.getHealthInc();
        return health;
    }

    public double getDamage () {
        if (armor != null)
            return damage - armor.getDamageDec();
        return damage;
    }

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

    public void setArmor (Armor a) {
        if (a.getName() != null)
            armor = a;
        else
            armor = null;
    }

    public boolean isRightOf (Plant p) {
        return pos[0] == p.pos[0] + 1 && pos[1] == p.pos[1];
    }

    public void attack (Plant p) {
        if (this.isRightOf(p))
            p.takeDamage(damage);
    }

    public void takeDamage (double d) {
        if (armor != null) {
            d = armor.takeDamage(d); 
            if (armor.getHealthInc() <= 0)
                armor = null;
        }
        this.takeDamage(d);
        if (this.getHealth() <= 0)
            this.kill();
    }

    public void kill () {
        System.out.println("Zombie at (" + pos[0] + "," + pos[1] + ") died!");
        map.getZA()[pos[0]][pos[1]] = null;
    }
}
