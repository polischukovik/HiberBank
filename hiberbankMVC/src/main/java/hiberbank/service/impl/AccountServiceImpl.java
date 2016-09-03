package hiberbank.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hiberbank.domain.Account;
import hiberbank.domain.Customer;
import hiberbank.repository.AccountRepository;
import hiberbank.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    
    //@Autowired
    private Logger logger = LogManager.getLogger(getClass());
 
    @Override
    @Transactional
    public Account addAccount(Account account) {
        Account savedAccount = accountRepository.saveAndFlush(account);
        return savedAccount;
    }
    
    @Override
    @Transactional
	public void deleteAccount(int id) {
		accountRepository.delete(id);
	}
    
	@Override
	@Transactional
	public Account editAccount(Account account) {
		return accountRepository.saveAndFlush(account);
	}
	
    @Override
    @Transactional(readOnly=true)
    public List<Account> getAll() {
    	logger.info(String.format("Entered getAll() Service method") );
    	logger.info(String.format("Executing findAll()") );
    	List<Account> result = accountRepository.findAll();
    	logger.info(String.format("Done findAll(): %d records retrieved",result.size()) );
    	logger.info(String.format("Listing result: ") );
    	for(Account account : result){
    		logger.info(String.format("\t%s", account));
    	}
        return result;
    }
    
    @Override
    @Transactional(readOnly=true)
    public Page<Account> getFiltered(String custName, String nbu, Pageable pageRequest) {
    	logger.info(String.format("Entered getFiltered() Service method") );
    	logger.info(String.format("Executing findFilteredByCustomerAndNbu(:s, :s) with search parameters [%s, %s]", custName, nbu) );
    	
    	Page<Account> result = accountRepository.findFilteredByCustomerAndNbu( nbu, pageRequest);
    	
    	logger.info(String.format("Done findFilteredByNameAndIpn(): %d records in %d pages retrieved",result.getTotalElements(), result.getTotalPages()));
    	logger.info(String.format("Listing result: ") );
    	
    	for(Account account : result){
    		logger.info(String.format("\t%s", account));
    	}
    	
        return result;
    }
}
