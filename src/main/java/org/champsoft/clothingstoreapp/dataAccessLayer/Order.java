package org.champsoft.clothingstoreapp.dataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //private identifier
    private String orderIdentifier;  //public identifier
    private String productIdentifier; // the product in the order
    private String name;
    private BigDecimal price;
    private String customerIdentifier; // the customer who bought the order

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private BigDecimal shippingPrice;
    private BigDecimal totalPrice;


}
