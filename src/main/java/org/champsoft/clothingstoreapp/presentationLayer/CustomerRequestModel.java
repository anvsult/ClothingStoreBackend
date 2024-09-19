package org.champsoft.clothingstoreapp.presentationLayer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerRequestModel {
    private String customerIdentifier;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
    private String username;
    private String password1;
    private String password2;
}
