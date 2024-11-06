package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerResponseModel;
import org.champsoft.clothingstoreapp.presentationLayer.OrderResponseModel;
import org.champsoft.clothingstoreapp.presentationLayer.ProductResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {
    @Mapping(target = "streetAddress", expression = "java(customer.getStreetAddress())")
    @Mapping(target = "province", expression = "java(customer.getProvince())")
    @Mapping(target = "postalCode", expression = "java(customer.getPostalCode())")
    @Mapping(target = "lastName", expression = "java(customer.getLastName())")
    @Mapping(target = "firstName", expression = "java(customer.getFirstName())")
    @Mapping(target = "emailAddress", expression = "java(customer.getEmailAddress())")
    @Mapping(target = "city", expression = "java(customer.getCity())")

    @Mapping(target = "description", expression = "java(product.getDescription())")
    @Mapping(target = "size", expression = "java(product.getSize())")

    @Mapping(target = "name", expression = "java(order.getName())")
    @Mapping(target = "price", expression = "java(order.getPrice())")
    @Mapping(target = "customerIdentifier", expression = "java(order.getCustomerIdentifier())")
    @Mapping(target = "productIdentifier", expression = "java(order.getProductIdentifier())")
    OrderResponseModel entityToResponseModel(Order order, CustomerResponseModel customer, ProductResponseModel product);
}
