import java.util.Random;
import java.time.LocalTime;

public class Map {
    private int xmax; //9 spaces horizontal
    private int ymax; //5 spaces vertical
    private Plant[][] PA;
    private Zombie[][] ZA;
    private Random rand;

    public Map (int x, int y) {
        xmax = x; //9
        ymax = y; //5
        PA = new Plant[ymax][xmax];
        ZA = new Zombie[ymax][xmax];
        rand = new Random (LocalTime.now().toNanoOfDay());
    }

    public int getXmax () {
        return xmax;
    }

    public int getYmax () {
        return ymax;
    }

    public Plant[][] getPA () {
        return PA;
    }

    public Zombie[][] getZA () {
        return ZA;
    }

    public boolean tileIsFree (int row, int col) { 
        return (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null);
    }

    /*  return true if successfully placed
        return false otherwise (no plant of that name/tile occupied/out of bounds)
    */
    public boolean placePlant (String n, int row, int col) {
        if (tileIsFree (row, col)) {
            PA[row][col] = new Plant (n, this, row, col);
            return true;
        }
        else {
            return false;
        }
    }

    //no armor (regular zombie)
    public boolean placeZombie (int row, int col) {
        if (tileIsFree (row, col)) {
            ZA[row][col] = new Zombie (this, row, col);
            return true;
        }
        else {
            return false;
        }
    }

    //with armor
    public boolean placeZombie (String a, int row, int col) {
        if (tileIsFree (row, col)) {
            ZA[row][col] = new Zombie (a, this, row, col);
            return true;
        }
        else
            return false;
    }
    /*
    public void moveLeft (Zombie z) {
        int row = z.getPos()[0];
        int col = z.getPos()[1];
        if (col - 1 >= 0 && PA[row][col-1] == null && ZA[row][col-1] == null) {
            z
        }
        else if (col - 1 == -1)
    }
    */

    public void spawnZombie (int s) {
        int i, rate;
        boolean spawn = false;
        boolean pass;
        if (s >= 30 && s <= 170) {
            if (s >= 30 && s <= 80) {
                if (s - 30 == 0 || (s - 30) % 10 == 0)
                    spawn = true;
            }
            if (s >= 81 && s <= 140) {
                if (s - 81 == 0 || (s - 81) % 5 == 0)
                    spawn = true;
            }
            if (s >= 141 && s <= 170) {
                if (s - 141 == 0 || (s - 141) % 3 == 0)
                    spawn = true;
            }
            if (spawn == true)
                do {
                    pass = placeZombie (rand.nextInt(ymax), xmax-1);
                } while (!pass);
        }
        if (s == 171) {
            do {
                pass = placeZombie (rand.nextInt(ymax), xmax-1);
            } while (!pass);
        }
        if (s >= 174 && s < 180) {
            for (i = 0 ; i < rand.nextInt(2) + 1 ; i++)
                do {
                    pass = placeZombie (rand.nextInt(ymax), xmax-1);
                } while (!pass);
        }
    }

/*  return true if zombie has reached the end
    return false otherwise
*/
    public boolean progress () {
        int row, col;
        boolean end;
        for (row = 0 ; row < ymax ; row++) {
            for (col = 0 ; col < xmax ; col++) {
                if (ZA[row][col] != null) {
                    end = ZA[row][col].moveLeft();
                    if (end)
                        return true;
                }
            }
        }
        for (row = 0 ; row < ymax ; row++) {
            for (col = 0 ; col < xmax ; col++) {
                if (ZA[row][col] != null)
                    ZA[row][col].attack();
            }
        }
        for (row = 0 ; row < ymax ; row++) {
            for (col = 0 ; col < xmax ; col++) {
                if (PA[row][col] != null)
                    PA[row][col].attack();
            }
        }
        return false;
    }

    private char displayCheckTile (int row, int col) {
        if (PA[row][col] != null)
            return PA[row][col].getName().charAt(0);
        if (ZA[row][col] != null)
            return 'Z';
        return ' ';
    }

    public void display () {
        int row, col;
        for (row = 0 ; row < ymax ; row++) {
            System.out.println("|===|===|===|===|===|===|===|===|===|");
            //System.out.println("|   |   |   |   |   |   |   |   |   |");
            for (col = 0 ; col < xmax ; col++) {
                System.out.print("| " + displayCheckTile(row, col) + " "); 
            }
            System.out.println("|");
        }
        System.out.println("|===|===|===|===|===|===|===|===|===|");
    }
}
