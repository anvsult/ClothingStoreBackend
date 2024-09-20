package org.champsoft.clothingstoreapp.dataAccessLayer;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //private identifier

    private String customerIdentifier; //public identifier
    private String lastName;
    private String firstName;
    private String emailAddress;

    private String  username;
    private String  password;

    private String streetAddress;
    private String postalCode;
    private String city;
    private String province;
}
