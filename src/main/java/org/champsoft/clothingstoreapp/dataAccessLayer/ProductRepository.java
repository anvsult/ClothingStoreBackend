package org.champsoft.clothingstoreapp.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Customer, Integer> {
}
