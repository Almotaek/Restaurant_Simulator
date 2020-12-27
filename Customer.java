/**
 * A blue print of the customer object
 *
 * @author Khalid Almotaery
 * @version 11/7/2020
 */
public class Customer
{
    int arrivalTime; /** The arraival time of the customer to the restaurant*/
    int serviceTime; /** The time that the customer spends to be served*/
    int profitGained; /** The money paied by the cutomer*/
     /**
     * Assigns values for the Customer object.
     */
    public Customer(int arrivalTime, int serviceTime, int profitGained)
    {
    this.arrivalTime =arrivalTime;this.serviceTime =serviceTime;this.profitGained=profitGained;  
    }
}
