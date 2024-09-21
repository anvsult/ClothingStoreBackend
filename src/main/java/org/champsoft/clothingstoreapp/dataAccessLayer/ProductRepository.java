package org.champsoft.clothingstoreapp.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductByProductIdentifier(String productId);
}
