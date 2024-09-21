package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.presentationLayer.CustomerRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerResponseModel;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseModel> getCustomers();

    CustomerResponseModel getCustomerById(String customerId);

    String addCustomer(CustomerRequestModel newCustomerData);

    String updateCustomer(String customerId, CustomerRequestModel newCustomerData);

    String deleteCustomerByCustomerId(String customerId);

    List<CustomerResponseModel> getCustomersByProductId(String productId);
}
