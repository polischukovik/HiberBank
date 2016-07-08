package ua.kyiv.polischukovik.HiberBank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Transactional
	public void addCustomer(Customer customer){
		customerDAO.save(customer);
    }
	
    @Transactional(readOnly=true)
	public Customer getCustomerById(int id){
		return customerDAO.findOne(id);
	}
	
    @Transactional(readOnly=true)
	public List<Customer> getCustomersByName(String namePart){
		return customerDAO.findAll();
	}
	
	public void updateCustomer(int custId, Customer customer ){
		dbIf.updateObject(custId, customer, Customer.class);
	}
}
