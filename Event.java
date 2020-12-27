/**
 * A blue print of the event object
 *
 * @author Khalid Almotaery
 * @version 11/7/2020
 */
public class Event implements Comparable<Event>
{
    int name; /** The name of the person making the event*/
    int time; /** The time of the event*/
    String type;
    boolean wasInQueue; /** Tells wheather the customer exited the queue*/
    
    /**
     * Assigns values for the Event object.
     */
    public Event(int name,int time,String type,boolean wasInQueue)
    {
      this.name = name;this.time = time;this.type = type;this.wasInQueue=wasInQueue;
    }

    /**
     * Compares the events based on their time.
     *
     * @param  e an Event type object
     * @return int showing the relationship between the two times
     */
    
    public int compareTo(Event e){
        return this.time - e.time;
    }
    

}
