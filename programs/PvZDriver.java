import java.util.Scanner;
import java.util.ArrayList;

public class PvZDriver {
	public static void main (String[] args) {
        Timer timer = new Timer (3, 0);
        Map map = new Map (9, 5);
        Player player = new Player ();
        Scanner sc = new Scanner (System.in);
		int sunTemp=0;
        String input;
        int row;
        int col;
        ArrayList<String> nameList;
		
        while (!timer.isDone() && !map.progress()) {
            System.out.println("Time..." + timer.getCurrentString());

            //map.progress();

            map.spawnZombie(timer.getCurrentSeconds());

            map.display();

            if (timer.getCurrentSeconds() != 0) {
                if ((timer.getCurrentSeconds()) % 3 == 0) {

                    System.out.print("Collect sun? [Y/N]: ");
                    input = sc.next();
                    if (input.equalsIgnoreCase("Y")){
						if(sunTemp==0)
							player.addSun(25 + map.getSunFromSunflowers());
						else
							player.addSun(sunTemp + 25 + map.getSunFromSunflowers());	
					}
					else sunTemp += (25 + map.getSunFromSunflowers());
                    System.out.println("Sun..." + player.getSun());
                }
                
                nameList = Plant.getNameListAfford(player);

                if (!nameList.isEmpty()) {
                    Plant.displayNameListAfford(player);
                    System.out.println("Add to board? (Input name of plant to buy; any key to continue)");
                    input = sc.next();
                    for (String s : nameList) {
                        if (input.equalsIgnoreCase(s)) {
                            System.out.print("Row: ");
                            row = sc.nextInt();
                            System.out.print("Column: ");
                            col = sc.nextInt();
                            if (map.tileIsFree(row-1, col-1)) {
                                map.placePlant (input, row-1, col-1);
                                player.buy(map.getPA()[row-1][col-1]);
                            }
                            else
                                System.out.println("Placement failed. Is the tile valid?");
                        }
                    }
                }
            }
            
            timer.progress(3);
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
