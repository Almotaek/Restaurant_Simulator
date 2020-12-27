import java.util.*;
/**
 * Testing class
 *
 * @author Khalid ALmotaery
 * @version 11/9/2020
 */
public class Controller
{    
    static int[] nI = {1,2,3,4,5,6,7,8,9,10};
     /**
     * Main method where testing starts
     *
     * @param  String[] args
     * @return null
     */
    public static void main(String[] args){
        Controller c = new Controller(); 
        long[] LinkedListTimes = new long[nI.length];
        long[] ArrayDequeTimes = new long[nI.length];
        //testing the method times with different number of iteams and random seeds:
        for(int i = 0; i <nI.length; i ++ ){
           LinkedListTimes[i] = c.timeOfSimulationWithLinkedLists(); 
        }
        for(int i = 0; i <nI.length; i ++ ){
            ArrayDequeTimes[i]= c.timeOfSimulationWithDeque(); 
        }
        for( int i = 1; i<nI.length; i++){
            System.out.println(ArrayDequeTimes[i]);
        }
         System.out.println("timesOfSimulationWithArrayDeque");
        for( int i = 1; i<nI.length; i++){
            System.out.println(LinkedListTimes[i]);
        }
        System.out.println("timesOfSimulationWithLinkedList");  
        c.netProfitAndCashers();
        System.out.println("profits with different cashers (1-10)");
        c.overflowWithDifferentCashers();
        System.out.println("% of overFlow with different cashers(1-8)");
        c.maxWaitTimeWithDifferentCashers();
        System.out.println("max waiting times with different cashers(1-8)");
        
    }
     /**
     * Runs the simulation
     *
     * @param  int cashers, the number of cashiers, int dequeuOrLinkedList is either 1 or 0 to choose the data structure
     * @return null
     */
    public void runProgram(int cashers,int dequeuOrLinkedList){
        Simulation r = new Simulation(cashers, dequeuOrLinkedList);
    }
     /**
     * Tests for time 
     *
     * @param 
     * @return null
     */
    public long timeOfSimulationWithLinkedLists(){
           Controller c = new Controller();
           long time1 = System.currentTimeMillis();
           c.runProgram(1,0);
           long time2 = System.currentTimeMillis();
           long time = time2-time1;
           return time;
    }
     /**
     * Tests for time 
     *
     * @param 
     * @return null
     */
    public long timeOfSimulationWithDeque(){
           Controller c = new Controller();
           long time1 = System.currentTimeMillis();
           c.runProgram(1,1);
           long time2 = System.currentTimeMillis();
           long time = time2-time1;
           return time;
    }
     /**
     *  Test for profits
     *
     * @param 
     * @return null
     */
    public void netProfitAndCashers(){
           Controller c = new Controller();
           int[] profit= new int[20];
           for( int i = 1; i<20; i++){
            Simulation r = new Simulation(i, 0);
            profit[i] = r.netProfit;
        }
        for(int i =1; i<20; i++){
            System.out.println(profit[i]);
        }
    }
     /**
     *  Test for overflow
     *
     * @param 
     * @return null
     */
    public void overflowWithDifferentCashers(){
           Controller c = new Controller();
           double[] flow= new double[10];
           for( int i = 1; i<10; i++){
            Simulation r = new Simulation(i, 0);
            flow[i] = r.percentOverFlow;
        }
        for(int i =1; i<10; i++){
            System.out.println(flow[i]);
        }
    }
     /**
     *  Test for waiting time
     *
     * @param 
     * @return null
     */
    public void maxWaitTimeWithDifferentCashers(){
           Controller c = new Controller();
           double[] wait= new double[10];
           for( int i = 1; i<10; i++){
            Simulation r = new Simulation(i, 0);
            wait[i] = r.avWaitTime;
        }
        for(int i =1; i<10; i++){
            System.out.println(wait[i]);
        }
}
}
