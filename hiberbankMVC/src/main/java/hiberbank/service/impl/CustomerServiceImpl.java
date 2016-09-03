package hiberbank.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Customer addCustomer(Customer customer) throws IllegalArgumentException{
    	verifyCustomer(customer);
    	Customer savedCustomer = customerRepository.saveAndFlush(customer);
        return savedCustomer;    	
    }
    
    private void verifyCustomer(Customer customer) {
		if(customer.getType() == null ) {
			throw new IllegalArgumentException("Type cannot be NULL");
		}
		if(customer.getStatus() == null ) {
			throw new IllegalArgumentException("Status cannot be NULL");
		}
		
	}

	@Override
    @Transactional
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
	}
    
    @Override
    @Transactional(readOnly=true)
	public Page<Customer> getByIpn(String ipn, Pageable pageRequest) {
		return customerRepository.findByIpn(ipn, pageRequest);
	}
    
	@Override
	@Transactional
	public Customer editCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
//    @Override
//    @Transactional(readOnly=true)
//    public Page<Customer> findAll(Pageable pageRequest) {
//    	logger.info(String.format("Entered getAll() Service method") );
//    	logger.info(String.format("Executing findAll()") );
//    	
//    	Page<Customer> result = customerRepository.findAll(pageRequest);
//    	
//    	logger.info(String.format("Done findAll(): %d records retrieved",result.getSize()) );
//    	logger.info(String.format("Listing result: ") );
//    	
//    	for(Customer customer : result){
//    		logger.info(String.format("\t%s", customer));
//    	}
//        return result;
//    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Customer> getFiltered(String name, String ipn, Pageable pageRequest) {
    	logger.info(String.format("Entered getFiltered() Service method") );
    	logger.info(String.format("Executing findFilteredByNameAndIpn(:s, :s) with search parameters [%s, %s]", name, ipn) );
    	
    	Page<Customer> result = customerRepository.findFilteredByNameAndIpn(name, ipn, pageRequest);
    	
    	logger.info(String.format("Done findFilteredByNameAndIpn(): %d records in %d pages retrieved",result.getTotalElements(), result.getTotalPages()));
    	logger.info(String.format("Listing result: ") );
    	
    	for(Customer customer : result){
    		logger.info(String.format("\t%s", customer));
    	}
    	
        return result;
    }


}
