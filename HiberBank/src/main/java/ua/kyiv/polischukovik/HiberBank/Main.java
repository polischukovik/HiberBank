package ua.kyiv.polischukovik.HiberBank;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.logging.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Main 
{
	
    public static void main( String[] args ) throws InterruptedException{
    	ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    	 
//    	 Customer cust = new Customer("Oleksii", "Oleksii", "Oleksii","1000258974", 0, 1, 3, 1, 3L, 2L);
//
//    	 CustController custController = ctx.getBean(CustController.class);
//    	 custController.addCustomer(cust);
//
    	 ctx.close();
    }
    

}
