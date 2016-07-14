package hiberbank.service;

import java.util.List;

import hiberbank.domain.Account;

public interface AccountService {
	Account addAccount(Account account);
	void deleteAccount(int id);
	Account editAccount(Account account);
	List<Account> getAll();
}
