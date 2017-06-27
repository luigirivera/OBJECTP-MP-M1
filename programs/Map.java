import java.util.Random;
import java.time.LocalTime;
/**
*
* This class instantiates a level map
* 
* @author Luis Lopez
* @author Louie Rivera
* @version 1.0
* @since 2017-06-26
*
*/
public class Map {
    private int xmax; //9 spaces horizontal
    private int ymax; //5 spaces vertical
    private Plant[][] PA;
    private Zombie[][] ZA;
    private Random rand;
    
   /**
	*
	* This constructor instantiates a map with appropriate size
	* @param x The maximum length of the map
	* @param y The maximum height of the map
	*
	*/
    public Map (int x, int y) {
        xmax = x; //9
        ymax = y; //5
        PA = new Plant[ymax][xmax];
        ZA = new Zombie[ymax][xmax];
        rand = new Random (LocalTime.now().toNanoOfDay());
    }
    
	/**
	*
	* This method returns the length of the map
	*
	* @return xmax The length of the map
	*/
    public int getXmax () {
        return xmax;
    }
    
	/**
	*
	* This method returns the height of the map
	*
	* @return ymax The height of the map
	*/
    public int getYmax () {
        return ymax;
    }
   
	/**
	*
	* This method returns all plants in map
	*
	* @return PA All plants in map
	*/
    public Plant[][] getPA () {
        return PA;
    }

	/**
	*
	* This method returns all zombies in map
	*
	* @return ZA All zombies in map
	*/
    public Zombie[][] getZA () {
        return ZA;
    }
    
	/**
	* 
	* This method checks and returns if a tile is free
	*
	* @param row The row requested
	* @param col The column requested
	* @return true If the tile is free
	* @return false If the tile is occupied
	*
	*/
    public boolean tileIsFree (int row, int col) { 
        return (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null);
    }
    
    /**
	* This method checks and returns if a plant is placeable
	*
	* @param n The name of the plant
	* @param row The row requested
	* @param col The column requested
	* @return true if successfully placed
    * @return false otherwise (no plant of that name/tile occupied/out of bounds)
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

    /**
	* This method checks and returns if a vanilla zombie is placeable
	*
	* @param row The row requested
	* @param col The column requested
	* @return true if successfully placed
    * @return false otherwise (no plant of that name/tile occupied/out of bounds)
    */
    public boolean placeZombie (int row, int col) {
        if (tileIsFree (row, col)) {
            ZA[row][col] = new Zombie (this, row, col);
            return true;
        }
        else {
            return false;
        }
    }

    /**
	* This method checks and returns if an armored zombie is placeable
	*
	* @param a The armor of the zombie
	* @param row The row requested
	* @param col The column requested
	* @return true if successfully placed
    * @return false otherwise (no plant of that name/tile occupied/out of bounds)
    */
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
    
    /**
    * This method makes zombies spawn at the end of the map
    *
    * @param s The second of time
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

/**
*  This method moces the zombies and make the plants attack every second
*   @return true if zombie has reached the end
*   @return false if otherwise
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

/**
*  This method gets the total amount of sun generated by sunflowers on board
*   @return total Sun generated by sunflowers on board
*
*/
    public int getSunFromSunflowers () {
        int row, col;
        int total = 0;  
        for (row = 0 ; row < ymax ; row++) {
            for (col = 0 ; col < xmax ; col++) {
                if (PA[row][col] != null && PA[row][col].getName().equals("Sunflower"))
                    total += 25;
            }
        }
        return total;
    }
    
	/**
	*
	* This method checks and returns the current occupant of the tile
	*
	* @param row The current row to check
	* @param col The current column to check
	* @return P A plant is located
	* @return Z A zombie is located
	* @return none Nothing is located
	*/
    private char displayCheckTile (int row, int col) {
        if (PA[row][col] != null)
            return PA[row][col].getName().charAt(0);
        if (ZA[row][col] != null)
            return 'Z';
        return ' ';
    }
    
	/**
	* This method displays the map currently in the game
	*/
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
