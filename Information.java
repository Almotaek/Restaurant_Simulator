import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
/**
 * The project's database and input 
 *
 * @author Khalid Almotaery
 * @version 11/7/2020
 */
public class Information
{
    File f;
    ArrayList<Customer> c; // This ArrayList is only used to test the LinkedList
    LinkedList<Customer> ll; 
    ArrayDeque<Customer> ad;
    Iterator<Customer> itr;
     /**
     * Initializes the LinkedList and finds the file location
     */
    public Information()
    {
        
        f= new File("C:\\Users\\User\\Desktop\\CS150\\Projects\\Project2\\input.txt");
        c = new ArrayList<Customer>();
        ll = new LinkedList<Customer>();
        ad = new ArrayDeque<Customer>();
    }
     /**
     * Reads the input file and and adds customers in the LinkedList
     *
     * @param  null
     * @return null
     */
    public void assignCustomers(int dataStructureNumber){
        int i =-2;
        try{
        Scanner s = new Scanner(f);       
        while(s.hasNext()){
        String asText = s.nextLine();
        i++;
    }       
        }catch(FileNotFoundException e){
        System.out.println("ERROR");
    }     
    //System.out.println(i);
    for(int k =0; k<i; k++){ 
        if(dataStructureNumber==0){
        c.add(new Customer(getArrivalTime(k),getServiceTime()/*getDepartureTime(k)*/,getProfit())); 
    }else if(dataStructureNumber==1){
        ll.addLast(new Customer(getArrivalTime(k),getServiceTime()/*getDepartureTime(k)*/,getProfit()));
    }else if(dataStructureNumber==2){
        ad.addLast(new Customer(getArrivalTime(k),getServiceTime()/*getDepartureTime(k)*/,getProfit()));
    }
    }
        for(int j=0; j<i; j++){
        //System.out.println("Customer "+j+" ArravalTime: "+c.get(j).arrivalTime+" DepartureTime: "+c.get(j).departureTime+" Gained Profit: "+c.get(j).profitGained);
    }  
    }

    /**
     * Randomly genrates a the money that the person spent in the store
     *
     * @param  null
     * @return  an int showing the price the customer paid
     */
    public int getProfit(){
        String asText = "";
        Random ran = new Random(System.currentTimeMillis());
        double profit;
        int profit2;
        double p1;
        double p2;
        double lowerBound;
        double upperBound;
        String[] help;
        try{
        Scanner s = new Scanner(f);
        asText = s.nextLine();
        
        }catch(FileNotFoundException e){
        System.out.println("ERROR");
    }
       help = asText.split(" ");
       p1 = Double.parseDouble(help[0]);
       p2 = Double.parseDouble(help[1]);
       lowerBound  = (p1)* ran.nextDouble();
       upperBound = p2 + ((10-p2) *ran.nextDouble());
       profit = lowerBound + ((upperBound-lowerBound)*ran.nextDouble());
       profit2 = (int) profit;
       //System.out.println(profit2);
       return profit2;
    }
     /**
     * Reads the file to find the staffing cost 
     *
     * @param  null
     * @return  an int showing the staffing cost 
     */
    public int getStaffingCost(){
    String asText = "";
    double dSalary=0;
    int salary=0;
    try{
        Scanner s = new Scanner(f);
        int i =0;
        while(s.hasNext()&&i<2){
        asText = s.nextLine();
        i++;
    }
    //System.out.println(asText);
        
        }catch(FileNotFoundException e){
        System.out.println("ERROR");
    }
    dSalary = Double.parseDouble(asText);
    salary = (int) dSalary;
    return salary;
}
     /**
     * Randomly generating a service time for each cutomer 
     *
     * @param  null
     * @return  an int showing the service time
     */
    public int getServiceTime(){
        Random ran = new Random(System.currentTimeMillis());
        String asText = "";
        double time;
        int time2;
        double p1;
        double p2;
        double lowerBound;
        double upperBound;
        String[] help;
    try{
        Scanner s = new Scanner(f);
        int i =0;
        while(s.hasNext()&&i<3){
        asText = s.nextLine();
        i++;
    }       
        }catch(FileNotFoundException e){
        System.out.println("ERROR");
    }
       
       help = asText.split(" ");
       p1 = Double.parseDouble(help[0]);
       p2 = Double.parseDouble(help[1]);
       lowerBound  = 30 + (p1-30)* ran.nextDouble();
       upperBound = p2 + ((300-p2) *ran.nextDouble());
       time = (int) lowerBound + ((upperBound-lowerBound)*ran.nextDouble());
       time2 = (int) time;
       //System.out.println(time2);
       return time2;   
    }
     /**
     * Reading the input file to get each customers arrival time. 
     *
     * @param  personNumber an int refering to the number of the customer in the list
     * @return  an int showing the arrival time
     */
    public int getArrivalTime(int personNumber){
       String asText = "";
       int hours =0;
       int minutes =0;
       int seconds =0;
       int time =0;
       final int OPENING_TIME_IN_SECONDS = 21600;
    try{
        Scanner s = new Scanner(f);
        int i =0;
        while(s.hasNext()&&i<4+personNumber){
        asText = s.nextLine();
        i++;
    }
    String[] help = asText.split(":");
    hours = Integer.parseInt(help[0]);
    minutes = Integer.parseInt(help[1]);
    seconds = Integer.parseInt(help[2]);
    
    time = ((hours*3600) + (minutes*60) + seconds)-OPENING_TIME_IN_SECONDS;
    //System.out.println(time);
        
        }catch(FileNotFoundException e){
        System.out.println("ERROR");
    }
  
    return time;   
    }
    /**
     *  Used to compare the LinkedList of Customers with ArrayDeque of Customers
     *
     * @param  null
     * @return LinkedList<Customer> of custmer objects
     */
    public LinkedList<Customer> getCustomerLinkedList(){
        int n=0;
        assignCustomers(1);
        return ll;
    }
     /**
     * Used to compare the ArrayDeque of Customers with a LinkedList of Customers 
     *
     * @param   null
     * @return  ArrayDeque<Customer> which contains customers
     */
        public ArrayDeque<Customer> getCustomerDeque(){
        assignCustomers(2);
        return ad;
    }
    
     /**
     * Gets the ArrayList to check if the LinkedList and the ArrayDeque data structures works.
     *
     * @param   null
     * @return  ArrayList<Customer> which contains customers
     */
        public ArrayList<Customer> getCustomerList(){
        assignCustomers(0);
        return c;
    }
   
}

