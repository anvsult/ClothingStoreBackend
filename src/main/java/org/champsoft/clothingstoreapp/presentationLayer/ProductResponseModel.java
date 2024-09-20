package org.champsoft.clothingstoreapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductResponseModel {
    private String productIdentifier;
    private String name;
    private String description;
    private String size;
    private BigDecimal price;
    private int quantity;
    private String product_status;

}
