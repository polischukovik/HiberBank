package ua.kyiv.polischukovik.HiberBank;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CustController {
	@Autowired
	public DBInterface dbIf;
	@Autowired
	private Logger log;
	
    public void setDbIf(DBInterface dbIf) {
		this.dbIf = dbIf;
	}

	public void addCustomer(Customer cust){
		log.info("Writting new customer to db: " + cust);
		dbIf.writeObject(cust);
    }
	
	public Customer getCustomerById(int id){
		return (Customer) dbIf.findObjectById(id, Customer.class);
	}
	
	public List<Customer> getCustomersByName(String namePart){
		return  dbIf.findObjectsByName(namePart, "Customers.getCustomersByName", Customer.class);
	}
	
	public void updateCustomer(int custId, Customer customer ){
		dbIf.updateObject(custId, customer, Customer.class);
	}
}
