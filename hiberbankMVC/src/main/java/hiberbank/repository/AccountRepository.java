package hiberbank.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hiberbank.domain.Account;
import hiberbank.domain.Customer;

public interface AccountRepository extends JpaRepository<Account, Integer> {
	@Query("select c from Account c where CONCAT('c.accClass', 'c.accKey','c.accSubacc') = :nbu")
	Page<Account> findByIpn(@Param("nbu") String nbu, Pageable pageRequest);
	
//	@Query(value="select c from Account c where c.customer like :customer and CONCAT('c.accClass', 'c.accKey','c.accSubacc') like :nbu" )
//	Page<Account> findFilteredByCustomerAndNbu(@Param("customer") String customer, @Param("nbu") String nbu, Pageable pageRequest);
	@Query(value="select c from Account c where CONCAT('c.accClass', 'c.accKey','c.accSubacc') like :nbu" )
	Page<Account> findFilteredByCustomerAndNbu(@Param("nbu") String nbu, Pageable pageRequest);
}