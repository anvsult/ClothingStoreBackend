package org.champsoft.clothingstoreapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerResponseModel {
    private String customerIdentifier; //public identifier
    private String lastName;
    private String firstName;
    private String emailAddress;

    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
}
