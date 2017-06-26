import java.util.Scanner;

public class PvZDriver {
	public static void main (String[] args) {
        Timer timer = new Timer (3, 0);
        Map map = new Map (9, 5);
        Player player = new Player ();
        Scanner sc = new Scanner (System.in);
        String input;
		
        while (!timer.isDone() /*&& owner is not dead*/) {
            System.out.println("Time..." + timer.getCurrentString());
            if (timer.getCurrentSeconds() != 0) {
                if ((timer.getCurrentSeconds() + 1) % 3 == 0) {
                    System.out.print("Collect sun? [Y/N]");
                    input = sc.next();
                    if (input.equalsIgnoreCase("Y"))
                        player.addSun(25);
                    System.out.println("Sun..." + player.getSun());
                }
            }
            
            timer.progress(1);
            /*
            if (owner is not dead)
                timer.progress(3);
            */
        }

		if (timer.isDone())
            System.out.println("TIME RAN OUT! YOU WIN!!");
		else
            System.out.println("THE ZOMBIES ATE YOUR BRAIN! YOU LOSE!!");

        sc.close();
	}
}
