public class Armor{
	private String name;
	private double damageDec;
	private double speedDec;
	private double healthInc;
	
	/*public Armor()
	{
		name="none";
		damageDec=0;
		speedDec=0;
		healthInc=0;
	}*/
	
	public Armor (String n)
	{
        switch (n) {
            case "Flag":
                name = n;
                damageDec = 1;
                speedDec = 0;
                healthInc = 0;
                break;
            case "Cone":
                name = n;
                damageDec = 2;
                speedDec = 2;
                healthInc = 17.75;
                break;
            default:
                name = null;
                break;
        }
	}
	
	public void setName(String n) { name = n; }
	public String getName() { return name; }
	
	public void setdamageDec(int d) { damageDec = d; }
	public double getdamageDec() { return damageDec; }
	
	public void setSpeedDec(int s) { speedDec = s; }
	public double getSpeedDec() { return speedDec;}
	
	public void setHealthInc(double h) { healthInc = s; }
	public double getHealthInc() { return healthInc;}
}
