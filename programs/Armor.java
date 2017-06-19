public class Armor{
	private String name;
	private int damageDec;
	private int speedDec;
	private double healthInc;
	
	public Armor()
	{
		name="none";
		damageDec=0;
		speedDec=0;
		healthInc=0;
	}
	
	public Armor(String n)
	{
		name=n;
		if(n.equalsIgnoreCase("Flag"))
		{
			damageDec=1;
			speedDec=0;
			healthInc=0;
		}
		else if(n.equalsIgnoreCase("Cone"))
				{
					damageDec=2;
					speedDec=2;
					healthInc=17.75;
				}
		
	}
	
	public void setName(String n) { name = n; }
	public String getName() { return name; }
	
	public void setdamageDec(int d) { damageDec = d; }
	public int getdamageDec() { return damageDec; }
	
	public void setSpeedDec(int s) { speedDec = s; }
	public int getSpeedDec() { return speedDec;}
	
	public void setHealthInc(double h) { healthInc = s; }
	public double getHealthInc() { return healthInc;}
}
