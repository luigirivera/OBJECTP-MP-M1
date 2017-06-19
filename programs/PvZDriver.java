public class PvZDriver
{
	public static void main(String[] args)
	{
		int time=0, result=0;
		
		do{
			time++;
			if(time<=180){
				
			}
			else result=1;
		}while(time<=180);
		
		if(result==1) System.out.println("TIME RAN OUT! YOU WIN!!");
		else System.out.println("THE ZOMBIES ATE YOUR BRAIN! YOU LOSE!!");
	}
}
