package hiberbank.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hiberbank.domain.Account;

public interface AccountService {
	Account addAccount(Account account);
	void deleteAccount(int id);
	Account editAccount(Account account);
	List<Account> getAll();
	Page<Account> getFiltered(String custName, String nbu, Pageable pageRequest);
}
