package org.champsoft.clothingstoreapp.dataAccessLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //private identifier


    private String productIdentifier;   //public identifier

    private String name;
    private String description;
    private String size;
    private BigDecimal price;
    private int quantity;

    private ProductStatus status;


}
