package org.champsoft.clothingstoreapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.champsoft.clothingstoreapp.dataAccessLayer.DeliveryStatus;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class OrderResponseModel {
    private String orderIdentifier;
    private String productIdentifier;
    private String name;
    private String price;
    private String customerIdentifier;


    private DeliveryStatus deliveryStatus;
    private BigDecimal shippingPrice;
    private BigDecimal totalPrice;

}
