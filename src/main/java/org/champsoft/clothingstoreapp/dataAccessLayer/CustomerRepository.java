package org.champsoft.clothingstoreapp.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findCustomerByCustomerIdentifier(String customerIdentifier);
}
