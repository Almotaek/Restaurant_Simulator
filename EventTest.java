import static org.junit.Assert.*;
import org.junit.Test;
/**
 * The test class EventTest.
 *
 * @author  Khalid ALmotaery
 * @version 11/7/2020
 */
public class EventTest
{
     /**
     * Tests the compareTo methods in the Event class.
     */
    @Test    
    public void compareToTest1()
    {
        Event e0 = new Event(0,100,"Arrival",false);  //event happens at time 100
        Event e1 = new Event(1,0,"Arrival",false);    //event happens at time 100
        
        int actual = e0.compareTo(e1); // compares e0 with e1
        int ex = 100; // expected value
        
        assertEquals(ex,actual); // result of test
        
    }
    /**
     * Tests the compareTo methods in the Event class.
     */
    @Test    
    public void compareToTest2()
    {
        Event e0 = new Event(0,0,"Arrival",false);  //event happens at time 0
        Event e1 = new Event(1,0,"Arrival",false);    //event happens at time 0
        
        int actual = e0.compareTo(e1); // compares e0 with e1
        int ex = 0; // expected value
        
        assertEquals(ex,actual); // result of test
        
    }
    /**
     * Tests the compareTo methods in the Event class.
     */
    @Test    
    public void compareToTest3()
    {
        Event e0 = new Event(0,100,"Arrival",false);  //event happens at time 100
        Event e1 = new Event(1,100,"Arrival",false);    //event happens at time 100
        
        int actual = e0.compareTo(e1); // compares e0 with e1
        int ex = 0; // expected value
        
        assertEquals(ex,actual); // result of test
        
    }
    
    @Test    
    public void compareToTest4()
    {
        Event e0 = new Event(0,0,"Arrival",false);  //event happens at time 0
        Event e1 = new Event(1,100,"Arrival",false);    //event happens at time 100
        
        int actual = e0.compareTo(e1); // compares e0 with e1
        int ex = -100; // expected value
        
        assertEquals(ex,actual); // result of test
        
    }


}
