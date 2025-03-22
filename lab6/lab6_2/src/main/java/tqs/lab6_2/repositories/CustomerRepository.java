package tqs.lab6_1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tqs.lab6_1.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer getCustomerById(int i);

}
