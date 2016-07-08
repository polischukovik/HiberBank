package ua.kyiv.polischukovik.HiberBank;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

}
