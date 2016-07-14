package hiberbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hiberbank.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}