package hiberbank.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hiberbank.domain.Account;
import hiberbank.domain.Customer;
import hiberbank.service.AccountService;
import hiberbank.service.CustomerService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/hiberbankMVC/service")
public class RestController {
	
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    
    private Logger logger = LogManager.getLogger(getClass());
	
    //Rest services
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Page<Customer> getCustomerListFiltered(@RequestParam("filter_1") String name, @RequestParam("filter_2") String ipn, @RequestParam("page") int page){
    	logger.info(String.format("Entered getCustomerListFiltered() Controller method with parameters filter_name=%s filter_ipn=%s page=%d",name,ipn,page) );
    	String nameStr, ipnStr;
    	if("".equals(name)){
    		if("".equals(ipn)){
    			nameStr = "%";
    			ipnStr = "%";
    		}
    		else{
    			nameStr = "%";
    			ipnStr = ipn;
    		}
    	}
    	else{
    		if("".equals(ipn)){
    			nameStr = "%" + name + "%";
    			ipnStr = "%";
    		}
    		else{
    			nameStr = "%" + name + "%";
    			ipnStr = ipn;
    		}
    	}
    	
    	return customerService.getFiltered(nameStr, ipnStr, new PageRequest(page-1, 20));
    }
    
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Page<Account> getAccountListFiltered(@RequestParam("filter_1") String customer, @RequestParam("filter_2") String nbu, @RequestParam("page") int page){
    	logger.info(String.format("Entered getAccountListFiltered() Controller method with parameters filter_customer=%s filter_nbu=%s page=%d",customer,nbu,page) );
    	String customerStr, nbuStr;
    	if("".equals(customer)){
    		if("".equals(nbu)){
    			customerStr = "%";
    			nbuStr = "%";
    		}
    		else{
    			customerStr = "%";
    			nbuStr = nbu;
    		}
    	}
    	else{
    		if("".equals(nbu)){
    			customerStr = "%" + customer + "%";
    			nbuStr = "%";
    		}
    		else{
    			customerStr = "%" + customer + "%";
    			nbuStr = nbu;
    		}
    	}
    	
    	return accountService.getFiltered(customerStr, nbuStr, new PageRequest(page-1, 20));
    }
//    @RequestMapping(value = "/customer", method = RequestMethod.GET)
//    public Page<Customer> getCustomerList(Pageable pageRequest){
//    	logger.info(String.format("Entered getCustomerList() Controller method") );
//   		return customerService.getFiltered("%","",pageRequest);
//    }    
    
    

}
