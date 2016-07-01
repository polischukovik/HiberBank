package ua.kyiv.polischukovik.HiberBank;


/**
 * Hello world!
 *
 */
public class Main 
{
	
    public static void main( String[] args ){
    	 Logging.initialize();
    	 
    	 Customer cust = new Customer("Oleksii", "1000258974", 0, 1, 3, 1, 3, 2);
    	 Customer.addCustomer(cust);
    	 Logging.log.trace(cust.getId());
    }
}
