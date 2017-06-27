/*  note: this timer is for phase 1
    it does not currently use any multithreading or actual time
    rather, it simulates the passage of time for turn-based gameplay
*/

/**
*
* This class is the timer for the game 
* @author Luis Lopez
* @version 1.0
* @since 2017-06-26
*
*/

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Timer {
    private LocalTime current;
    private LocalTime max;
	
	/**
	*
	* This constructor initiates the timer
	*
	* @param m The minute time
	* @param s The second time
	*/
    public Timer (int m, int s) {
        current = LocalTime.MIN;
        max = LocalTime.of(0, m, s);
    }
	
	/**
	*
	* This method returns the current time
	*
	* @return current The current time
	*/
    public LocalTime getCurrent () {
        return current;
    }

	/**
	*
	* This method returns the end time
	*
	* @return max The maximum time
	*/
    public LocalTime getMax () {
        return max;
    }

	/**
	*
	* This method returns the current time, formatted
	*
	* @return mm:ss A string of current time
	*/
    public String getCurrentString () {
        return current.format(DateTimeFormatter.ofPattern("mm:ss"));
    }

	/**
	*
	* This method returns the end time, formatted
	*
	* @return mm:ss A string of end time
	*/
    public String getMaxString () {
        return max.format(DateTimeFormatter.ofPattern("mm:ss"));
    }
	
	/**
	*
	* This method returns the current time, formatted
	*
	* @return seconds The current state of seconds
	*/
    public int getCurrentSeconds () {
        return current.toSecondOfDay();
    }

	/**
	*
	* This method increases the time
	*
	* @param s The second to increment
	*/
    public void progress (int s) {
        current = current.plusSeconds(s);
    }

	/**
	*
	* This method returns if the time is done or not
	*
	* @return true If time is up
	* @return false If time is not up
	*/
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
