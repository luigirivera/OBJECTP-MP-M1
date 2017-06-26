public class Map {
    private int xmax; //9 spaces horizontal
    private int ymax; //5 spaces vertical
    private Plant[][] PA;
    private Zombie[][] ZA;

    public Map (int x, int y) {
        xmax = x; //9
        ymax = y; //5
        PA = new Plant[xmax][ymax];
        ZA = new Zombie[xmax][ymax];
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
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
            PA[row][col] = new Plant (n, this, row, col);
            return true;
        }
        else
            return false;
    }

    //no armor (regular zombie)
    public boolean placeZombie (int row, int col) {
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
            ZA[row][col] = new Zombie (this, row, col);
            return true;
        }
        else
            return false;
    }

    //with armor
    public boolean placeZombie (String a, int row, int col) {
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
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
    private char displayCheckTile (int row, int col) {
        if (PA[row][col] != null)
            return 'P';
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
