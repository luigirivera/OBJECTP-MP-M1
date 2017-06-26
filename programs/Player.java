public class Player {
    private int sun;

    public Player () {
        sun = 0;
    }

    public int getSun () {
        return sun;
    }

    public void addSun (int s) {
        sun = sun + s;
    }

    public boolean buy (Plant p) {
        if (sun >= p.getCost()) {
            sun = sun - p.getCost();
            return true;
        }
        else
            return false;
    }
}
