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
public class OrderRequestModel {
    private String orderIdentifier;
    private String customerIdentifier;
    private String productIdentifier;

    //////IF THESE ARE REMOVED, UPDATING AN ORDER WILL MAKE THESE VALUES NULL/////
//    private String name;
//    private String price;
//    private DeliveryStatus deliveryStatus;
//    private BigDecimal totalPrice;
    //////////////////////////////////////////////////////////////////////////////

    private BigDecimal shippingPrice;
}
