public class PvZDriver
{
	public static void main(String[] args)
	{
		Timer timer = new Timer();
		Thread time = new Thread(timer);
		
		time.start();
		
		//game to be added
		while((time.getState()!=Thread.State.TERMINATED) && (game.getState()!=Thread.State.TERMINATED));
		
		if(time.getState()==Thread.State.TERMINATED) System.out.println("TIME RAN OUT! YOU WIN!!");
		else System.out.println("THE ZOMBIES ATE YOUR BRAIN! YOU LOSE!!");
	}
}
