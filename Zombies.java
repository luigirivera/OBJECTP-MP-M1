public class Zombies
{
	private int speed;
	private double health;
	private int damage;
	private Armor armor;
	
	public Zombies()
	{
		armor = new Armor();
		speed=4;
		damage=10;
		health=70;
	}
	
	public void toFlag()
	{
		armor = new Armor("Flag");
		speed=4-armor.getSpeedDec();
		damage=10-armor.getDamageDec();
		health=70+armor.getHealthInc();
	}
	
	public void toCone()
	{
		armor = new Armor("Cone");
		speed-=armor.getSpeedDec();
		damage-=armor.getDamageDec();
		health+=armor.getHealthInc();
	}
}