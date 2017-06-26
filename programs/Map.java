public class Map {
    private int xmax; //9 spaces horizontal
    private int ymax; //5 spaces vertical
    private Plant[][] PA;
    private Zombie[][] ZA;

    public Map () {
        xmax = 9;
        ymax = 5;
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

    /*  return true if successfully placed
        return false otherwise (no plant of that name/tile occupied/out of bounds)
    */
    private boolean placePlant (String n, int row, int col) {
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
            PA[row][col] = new Plant (n, this, row, col);
            return true;
        }
        else
            return false;
    }

    //no armor (regular zombie)
    private boolean placeZombie (int row, int col) {
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
            ZA[row][col] = new Zombie (this, row, col);
            return true;
        }
        else
            return false;
    }

    //with armor
    private boolean placeZombie (String a, int row, int col) {
        if (row < ymax && col < xmax && PA[row][col] == null && ZA[row][col] == null) {
            ZA[row][col] = new Zombie (a, this, row, col);
            return true;
        }
        else
            return false;
    }

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
