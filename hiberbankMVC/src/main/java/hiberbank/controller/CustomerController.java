package hiberbank.controller;


import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.google.gson.Gson;

import hiberbank.domain.Customer;
import hiberbank.service.AccountService;
import hiberbank.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private AccountService accountService;
    
    private Logger logger = LogManager.getLogger(getClass());
    
    @RequestMapping("/hiberbankMVC")
    public String index(Model model) {
    	logger.info("Entered index() Controller method");
    	
    	String page = "index";
        logger.info(String.format("Returning page %s", page));
        return page;
    }

//    @RequestMapping("/hiberbankMVC/cust")
//    public String customerMaster(Model model) {
//    	logger.info("Entered customerMaster() Controller method");
//    	
//    	String page = "customer_master";
//        logger.info(String.format("Returning page %s", page));
//        return page;
//    }
    
    @RequestMapping("/hiberbankMVC/cust")
    public String customerMasterAttributes(@RequestParam(required = false) String filterName, 
    		@RequestParam(required = false) String filterIpn, @RequestParam(required = false) String pageNo, Model model) {
    	logger.info("Entered customerMasterAttributes() Controller method");
    	logger.info(String.format("Attributes: filter_name=%s filter_ipn=%s page=%s", filterName, filterIpn, pageNo));
    	model.addAttribute("filterName", String.valueOf(filterName));
    	model.addAttribute("filterIpn", String.valueOf(filterIpn));
    	model.addAttribute("page", String.valueOf(pageNo));
        String page = "customer_master";
        logger.info(String.format("Returning page %s", page));
        return page;
    }
    
    @RequestMapping(value = "/hiberbankMVC/cust/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> addCustomer(@ModelAttribute() Customer customer, Model model) {
    	logger.info("Entered addCustomer() Controller method");
    	
    	logger.info("Updating customer: " + customer);
    	try{
    		Customer savedCustomer = customerService.addCustomer(customer);
    		logger.info(String.format("Customer saved:  %s", savedCustomer));
    	}catch(IllegalArgumentException e){	
    		logger.error("{" + e.getMessage() + "}");
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Gson().toJson(e.getMessage()));
    	} 	
    	
        return ResponseEntity.status(HttpStatus.OK).body(new Gson().toJson("Ok"));
    }
    
    @RequestMapping("/hiberbankMVC/cust/{id}")
    public String customerDetails(@PathVariable(value = "id") int id, Model model) {
    	logger.info("Entered customerDetails() Controller method");
    	
    	String page = "customer_details";
    	model.addAttribute("customerId", String.valueOf(id));
        logger.info(String.format("Returning page %s", page));
        return page;
    }
    
    @RequestMapping(value = "/hiberbankMVC/acc")
    public String accountMaster(Model model) {
    	logger.info("Entered accountMaster() Controller method");
    	
    	String page = "account_master";
        logger.info(String.format("Returning page %s", page));
        return page;
    }
    

}




//    @RequestMapping("/")
//    public String index(Model model) {
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("contacts", contactService.listContacts(null));
//        return "index";
//    }

//    @RequestMapping("/")
//    public String index(Model model) {
//    	logger.info("Inside " + this.getClass() + " webMvcController index");
//        model.addAttribute("customers", customerService.getAll());
//        return "index";
//    }
    


//    @RequestMapping("/group_add_page")
//    public String groupAddPage() {
//        return "group_add_page";
//    }
//
//    @RequestMapping("/group/{id}")
//    public String listGroup(@PathVariable(value = "id") long groupId, Model model) {
//        Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;
//
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("currentGroup", group);
//        model.addAttribute("contacts", contactService.listContacts(group));
//        return "index";
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.POST)
//    public String search(@RequestParam String pattern, Model model) {
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("contacts", contactService.searchContacts(pattern));
//        return "index";
//    }
//
//    @RequestMapping(value = "/contact/delete", method = RequestMethod.POST)
//    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete, Model model) {
//        if (toDelete != null)
//            contactService.deleteContact(toDelete);
//
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("contacts", contactService.listContacts(null));
//
//        return new ResponseEntity<Void>(HttpStatus.OK);
//    }
//
//    @RequestMapping(value="/contact/add", method = RequestMethod.POST)
//    public String contactAdd(@RequestParam(value = "group") long groupId,
//                             @RequestParam String name,
//                             @RequestParam String surname,
//                             @RequestParam String phone,
//                             @RequestParam String email,
//                             Model model)
//    {
//        Group group = (groupId != DEFAULT_GROUP_ID) ? contactService.findGroup(groupId) : null;
//
//        Contact contact = new Contact(group, name, surname, phone, email);
//        contactService.addContact(contact);
//
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("contacts", contactService.listContacts(null));
//        return "redirect:/";
//    }
//
//    @RequestMapping(value="/group/add", method = RequestMethod.POST)
//    public String groupAdd(@RequestParam String name, Model model)
//    {
//        contactService.addGroup(new Group(name));
//
//        model.addAttribute("groups", contactService.listGroups());
//        model.addAttribute("contacts", contactService.listContacts(null));
//        return "index";
//    }

