package org.champsoft.clothingstoreapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductRequestModel {
    private String productIdentifier;
    private String name;
    private String description;
    private String size;
    private String price;
    private int quantity;
    private String product_status;
}
