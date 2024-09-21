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
    private String name;
    private BigDecimal price;
    private DeliveryStatus deliveryStatus;
    private BigDecimal shippingPrice;
    private BigDecimal totalPrice;

    //THE CUSTOMER WHO BOUGHT THE ORDER
    private String customerIdentifier;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;

    //THE PRODUCT IN THE ORDER
    private String productIdentifier;
    private String description;
    private String size;

}
