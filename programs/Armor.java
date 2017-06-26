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
	
	public void setDamageDec(double d) { damageDec = d; }
	public double getDamageDec() { return damageDec; }
	
	public void setSpeedDec(double s) { speedDec = s; }
	public double getSpeedDec() { return speedDec;}
	
	public void setHealthInc(double h) { healthInc = h; }
	public double getHealthInc() { return healthInc;}

    public double takeDamage (double d) {
        if (healthInc >= d) {
            healthInc = healthInc - d;
            d = 0;
        }
        else {
            d = d - healthInc;
            healthInc = 0;
        }
        return d;
    }
}
