package hiberbank.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import hiberbank.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	@Query("select c from Customer c where c.ipn = :ipn")
	Page<Customer> findByIpn(@Param("ipn") String ipn, Pageable pageRequest);
	
	@Query(value="select c from Customer c where CONCAT(c.firstName,' ',c.lastName,' ',familyName) like :name or c.ipn = :ipn" )
	Page<Customer> findFilteredByNameAndIpn(@Param("name") String name, @Param("ipn") String ipn, Pageable pageRequest);
	
}
