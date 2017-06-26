/*  note: this timer is for phase 1
    it does not currently use any multithreading or actual time
    rather, it simulates the passage of time for turn-based gameplay
*/

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer {
    private LocalTime current;
    private LocalTime max;

    public Timer (int m, int s) {
        current = LocalTime.MIN;
        max = LocalTime.of(0, m, s);
    }

    public void progress (int s) {
        current = current.plusSeconds(s);
    }

    public boolean isDone () {
        return current.equals(max);
    }

    /*
    public static void main (String[] args) {
        Timer t1 = new Timer (3, 0);
        System.out.println(t1.current.format(DateTimeFormatter.ofPattern("mm:ss")));
        t1.progress(); 
        System.out.println(t1.current.format(DateTimeFormatter.ofPattern("mm:ss")));
    }
    */
}
