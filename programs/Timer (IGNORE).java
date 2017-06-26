public class Timer implements Runnable{
	private int count;
	
	public Timer()
	{
		count=180;
	}	
	
	public void run(){
		do{
			try{
				Thread.sleep(1000);
				count--;
				
			} catch(Exception e){};
		}while(count!=0);
	}
	
	public void display()
	{
		System.out.println("Time left " + count);
	}
}