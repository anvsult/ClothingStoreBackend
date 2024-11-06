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

    //////IF THESE ARE REMOVED, UPDATING AN ORDER WILL MAKE THESE VALUES NULL/////
    private String customerIdentifier;
    private String productIdentifier;
    private String name;
    private BigDecimal shippingPrice;
    private DeliveryStatus deliveryStatus;
    //////////////////////////////////////////////////////////////////////////////

}
