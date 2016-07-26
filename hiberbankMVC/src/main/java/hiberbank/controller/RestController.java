package hiberbank.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping(value = "/customer", method = RequestMethod.GET, params = {"filter_name", "filter_ipn"})
    public Page<Customer> getCustomerListFiltered(@RequestParam("filter_name") String name, @RequestParam("filter_ipn") String ipn, Pageable pageRequest){
    	logger.info(String.format("Entered getCustomerListFiltered() Controller method with parameters filter_name=%s filter_ipn=%s",name,ipn) );
    	String nameStr = name.equals("") ? "%" : "%" + name + "%";
    	return customerService.getFiltered(nameStr, ipn, pageRequest);
    }
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Page<Customer> getCustomerList(Pageable pageRequest){
    	logger.info(String.format("Entered getCustomerList() Controller method") );
   		return customerService.getFiltered("%","",pageRequest);
    }    
    
    

}
