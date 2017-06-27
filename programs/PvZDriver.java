import java.util.Scanner;
import java.util.ArrayList;

public class PvZDriver {
	public static void main (String[] args) {
        Timer timer = new Timer (3, 0);
        Map map = new Map (9, 5);
        Player player = new Player ();
        Scanner sc = new Scanner (System.in);
        String input;
        ArrayList<String> nameList;
		
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
                
                nameList = Plant.getNameListAfford(player);
                if (nameList.size() > 0) {
                    System.out.println("Can afford: ");
                    for (String s : nameList) {
                        System.out.println(s);
                    }
                    System.out.println("");
                    System.out.println("Add to board? (Input name of plant to buy; any key to continue");
                    input = sc.next();
                    for (String s : nameList) {
                        if (input.equalsIgnoreCase(s))
                            System.out.println("Debug line!");
                    }
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
