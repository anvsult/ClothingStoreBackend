package org.champsoft.clothingstoreapp.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Customer, Integer> {
}
