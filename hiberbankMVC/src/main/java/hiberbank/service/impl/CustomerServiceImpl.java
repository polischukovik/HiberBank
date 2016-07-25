package hiberbank.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hiberbank.domain.Customer;
import hiberbank.repository.CustomerRepository;
import hiberbank.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    
    //@Autowired
    private Logger logger = LogManager.getLogger(getClass());
 
    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;
    }
    
    @Override
    @Transactional
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
	}
    
    @Override
    @Transactional(readOnly=true)
	public Customer getByIpn(String ipn) {
		return customerRepository.findByIpn(ipn);
	}
    
	@Override
	@Transactional
	public Customer editCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
    @Override
    @Transactional(readOnly=true)
    public List<Customer> getAll() {
    	logger.info(String.format("Entered getAll() Service method") );
    	logger.info(String.format("Executing findAll()") );
    	List<Customer> result = customerRepository.findAll();
    	logger.info(String.format("Done findAll(): %d records retrieved",result.size()) );
    	logger.info(String.format("Listing result: ") );
    	for(Customer customer : result){
    		logger.info(String.format("\t%s", customer));
    	}
        return result;
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<Customer> getFiltered(String name, String ipn) {
    	logger.info(String.format("Entered getFiltered() Service method") );
    	logger.info(String.format("Executing findFilteredByNameAndIpn(:s, :s) with search parameters [%s, %s]", name, ipn) );
    	List<Customer> result = customerRepository.findFilteredByNameAndIpn(name, ipn);
    	logger.info(String.format("Done findFilteredByNameAndIpn(): %d records retrieved",result.size()) );
    	logger.info(String.format("Listing result: ") );
    	for(Customer customer : result){
    		logger.info(String.format("\t%s", customer));
    	}
        return result;
    }
}
