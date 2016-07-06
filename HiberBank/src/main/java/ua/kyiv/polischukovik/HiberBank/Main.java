package ua.kyiv.polischukovik.HiberBank;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
	
    public static void main( String[] args ){
    	ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	 
    	 Customer cust = new Customer("Oleksii", "Oleksii", "Oleksii","1000258974", 0, 1, 3, 1, 3L, 2L);
    	 
    	 CustController custController = ctx.getBean(CustController.class);
    	 custController.addCustomer(cust);
    	 
    	 ctx.close();
    }
    

}
