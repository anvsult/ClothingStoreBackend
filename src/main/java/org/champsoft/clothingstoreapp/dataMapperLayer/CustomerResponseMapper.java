package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Customer;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerResponseMapper {
    CustomerResponseModel entityToResponseModel(Customer customer);
    List<CustomerResponseModel> entityListToResponseModelList(List<Customer> customers);
}
