package org.champsoft.clothingstoreapp.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllOrdersByProductIdentifier(String productId);


    Order findOrderByOrderIdentifier(String orderId);

    List<Order> findOrdersByCustomerIdentifier(String customerId);

    List<Order> findCustomersByProductIdentifier(String productId);

    List<Order> findOrdersByProductIdentifier(String productId);
}
