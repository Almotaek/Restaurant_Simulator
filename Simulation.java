import java.util.*;
/**
 * The simulation blue print 
 *
 * @author Khalid Almotaery
 * @version 11/7/2020
 */
public class Simulation
{   
    //Information object:
    Information i;
    
    //needed fields:
    final int CLOSING_TIME = 54000;
    int casherSalary;
    int cashersTotal=0;
    int cashersAvailable;
    
    int customerNumber=0;
    int howLong=0;
    int overFlowCount=0;
    int dailyProfit=0;
    int nextEvent=0;
    int netProfit =0;
    double avWaitTime=0;
    double percentOverFlow=0;
    
    
    // Data structures:
    PriorityQueue<Event> eventSet;
    ArrayList<Customer> customerList;
    LinkedList<Customer> customerLinkedList;
    ArrayDeque<Customer> customerDeque;
    ArrayDeque<Customer> queue = new ArrayDeque<Customer>();
    Queue<Event> q;
    Iterator<Customer> itr;
    
    
    /**
     * Initializes the data structures and converts the LinkedList from Information to an ArrayList
     */
    public Simulation(int cashers,int dequeOrLinkedList)
    {
        i = new Information();
        eventSet = new PriorityQueue<Event>();
        customerList = new ArrayList<Customer>();
        customerDeque = new ArrayDeque<Customer>();
        
        cashersAvailable=cashers;
        cashersTotal = cashers;
        casherSalary = i.getStaffingCost();
        customerLinkedList=i.getCustomerLinkedList();
        itr = customerLinkedList.iterator();
        while(itr.hasNext()){
            customerList.add(itr.next());
        }
        
        if(dequeOrLinkedList==0){
         q = new ArrayDeque<Event>();
    }else{
         q = new LinkedList<Event>();
    }
         nextEvent();
    }
    /**
     * Adds all the arrival events to the priorty queue
     *
     * @param  null
     * @return null
     */
    public void nextEvent(){
        for(int j=0; j<customerList.size(); j++){
         Event ev = new Event(j,customerList.get(j).arrivalTime,"ARRIVAL",false);
         eventSet.add(ev);  
        }
        runSimulation();
    }
     /**
     * Runs the whole simlation
     *
     * @param  null
     * @return null
     */
    public void runSimulation(){
            //needed local varibales:
            int prevCusServTime=0;
            int waitingTime=0;
            int profit=0;
            int counter=0;
            

            
            Event e = null; // the event object
            
            while(!eventSet.isEmpty()){ // loos until there are no events left
                
                e = eventSet.remove(); //getting and removing the sooner events 
                
                if(e.time>CLOSING_TIME){ //stops looping when the store is closed
                    break;
                }
                
                //Departure case:
                if(e.type.equals("Departure")){
                    cashersAvailable++; //makes more cashers available 
                    System.out.println("User # "+e.name+" Leaves at time "+e.time);
                    //makes the next person from the queue if it is not empty: 
                    if(!q.isEmpty()){
                       prevCusServTime=e.time;
                       e = q.poll();
                       e.time = prevCusServTime;
                       waitingTime = (e.time) - customerList.get(e.name).arrivalTime;
                       avWaitTime=avWaitTime+waitingTime;
                       counter++;
                       e.wasInQueue =true;
                       eventSet.add(e);
                    }
                }else{
                    if(e.wasInQueue){
                    System.out.println("User # "+e.name+" is out of queue at time "+e.time+" the user waited in the queue for" +waitingTime);
                    }else{
                    System.out.println("User # "+e.name+" Enters at time "+e.time);
                }
                //Serves the custmoer and makes a departure event:
                if(cashersAvailable>0){
                    cashersAvailable--;
                    howLong = customerList.get(e.name).serviceTime;
                    profit=customerList.get(e.name).profitGained;
                    dailyProfit+=profit;
                    System.out.println("And gets served for "+howLong+" seconds"+" paying $"+profit);
                    e.time+=howLong;
                    e.type = "Departure";
                    eventSet.add(e);   
                }else{
                    System.out.println("User # "+e.name+" waits in queue at time "+e.time/*+" and gets out of queue at time "+prevCusServTime*/);
                    //makes customers wait in the queue:
                    if(queue.size()<cashersTotal*8){
                    queue.add(customerList.get(e.name));
                    q.add(e);
                }else{
                    //makes a customer overflow when the queue is c*8 long
                    System.out.println("User # "+e.name+" is an overflow!");
                    eventSet.remove(e.name);
                    overFlowCount++;
                }
                    
                }
                
            }
        }
        double dOverFlowCount=overFlowCount;
        double dSize=customerList.size();
        percentOverFlow = ((dOverFlowCount/dSize)*100);
        netProfit = (dailyProfit-(cashersTotal*casherSalary));
        avWaitTime = (avWaitTime/counter);
        System.out.println("With "+cashersTotal+" cashers, the restaurant has %"+percentOverFlow+" cutomers that were an overflow.");
        System.out.println("The daily net profit is: $"+netProfit);
        System.out.println("The maximum average waiting time is: "+avWaitTime+" Seconds");
    }

}
