import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;
/**
 * The test class EventTest.
 *
 * @author  Khalid ALmotaery
 * @version 11/7/2020
 */
public class InformationTest
{
     /**
     * Tests the assingCustomers Methods by comapring the results from a LinkedList and an ArrayList
     */
    @Test    
    public void assignCustomersLinkedListTest()
    {
        Information info = new Information(); 
        Iterator<Customer> itr;
        ArrayList<Customer> c;
        LinkedList<Customer> ll;
        String ActualText = "";
        String ExpectedText = "";
        
        //info.assignCustomers(1);
        
        ll = info.getCustomerLinkedList();
        c = info.getCustomerList();
        
        itr=ll.iterator();
        //checks if the customers arrival times match when using LinkedList and ArrayLists:
        while(itr.hasNext()){
            ActualText = ActualText+itr.next().arrivalTime;
        }    
        
        for(int k =0; k<c.size(); k++){ 
         ExpectedText=ExpectedText+c.get(k).arrivalTime;
        }
        
        assertEquals(ExpectedText,ActualText); // result of test
        
    }
    /**
     * Tests the assingCustomers Methods by comapring the results from a ArrayDeque and an ArrayList
     */
    @Test    
    public void assignCustomersArrayDequeTest()
    {
        Information info = new Information(); 
        Iterator<Customer> itr;
        ArrayList<Customer> c;
        ArrayDeque<Customer> ab;
        String ActualText = "";
        String ExpectedText = "";
        
        //info.assignCustomers(1);
        
        ab = info.getCustomerDeque();
        c = info.getCustomerList();
        
        itr=ab.iterator();
        //checks if the customers arrival times match when using ArrayDeque and ArrayLists:
        
        while(itr.hasNext()){
            ActualText = ActualText+itr.next().arrivalTime;
        }    
        
        for(int k =0; k<c.size(); k++){ 
         ExpectedText=ExpectedText+c.get(k).arrivalTime;
        }
        
        assertEquals(ExpectedText,ActualText); // result of test
        
    }
     /**
     * Tests the range of the profit
     */
    @Test    
    public void getProfitRangeTest()
    {
        Information info = new Information(); 
        boolean inRange=false;
        boolean expectedRange = true;
        int acutal = info.getProfit();
        if(acutal>0&&acutal<10){
            inRange=true;
        }
        assertEquals(inRange,expectedRange);
    }
     /**
     * Tests the range of the service time
     */
    @Test    
    public void getSeviceTimeRangeTest()
    {
        Information info = new Information(); 
        boolean inRange=false;
        boolean expectedRange = true;
        int acutal = info.getServiceTime();
        if(acutal>30&&acutal<300){
            inRange=true;
        }
        assertEquals(expectedRange,inRange);
    }
        @Test    
    public void getStaffingCostTest()
    {
        Information info = new Information(); 
        int act = info.getStaffingCost();
        int ex = 300;
        assertEquals(ex,act);
    }
}
