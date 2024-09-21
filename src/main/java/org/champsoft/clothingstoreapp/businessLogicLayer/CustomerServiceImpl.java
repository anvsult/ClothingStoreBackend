package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.*;
import org.champsoft.clothingstoreapp.dataMapperLayer.CustomerRequestMapper;
import org.champsoft.clothingstoreapp.dataMapperLayer.CustomerResponseMapper;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.CustomerResponseModel;
import org.champsoft.clothingstoreapp.presentationLayer.ProductResponseModel;
import org.champsoft.clothingstoreapp.utilities.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerRequestMapper customerRequestMapper;
    private final ProductService productService;
    private final OrderRepository orderRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerResponseMapper customerResponseMapper, CustomerRequestMapper customerRequestMapper, ProductService productService, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerById(String customerId) {
        Customer customer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
        CustomerResponseModel result = null;
        if (customer == null){
            throw new NotFoundException("Customer with " + customerId + " not found");
        } else {
            result = this.customerResponseMapper.entityToResponseModel(customer);
        }
        return result;
    }

    @Override
    public String addCustomer(CustomerRequestModel newCustomerData) {
        String message = "";
        String pw1 = newCustomerData.getPassword1();
        String pw2 = newCustomerData.getPassword2();
        if (!pw1.equals(pw2)){
            message = "Passwords do not match";
        } else {
            String customerId = newCustomerData.getCustomerIdentifier();
            Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
            if (foundCustomer != null){
                message = "Customer with " + customerId + " already exists";
            } else {
                Customer customer = this.customerRequestMapper.requestModelToEntity(newCustomerData);
                customer.setCustomerIdentifier(customerId);
                customer.setPassword(newCustomerData.getPassword1());
                this.customerRepository.save(customer);
                message = "Customer saved successfully";

            }
        }
        return message;
    }

    @Override
    public String updateCustomer(String customerId, CustomerRequestModel newCustomerData) {
        String message = "";
        Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
        if (foundCustomer == null){
            message = "Customer with id: " + customerId + " not found in repository.";
        } else {
            String pw1 = newCustomerData.getPassword1();
            String pw2 = newCustomerData.getPassword2();
            if (pw1 == null) { pw1 = ""; }
            if (pw2 == null) { pw2 = ""; }
            if (pw1.equals(pw2)) {
                Customer customer = this.customerRequestMapper.requestModelToEntity(newCustomerData);
                customer.setPassword(newCustomerData.getPassword1());
                customer.setCustomerIdentifier(customerId); //important
                customer.setId(foundCustomer.getId());
                Customer savedCustomer = this.customerRepository.save(customer);
                message = "Customer with id : " + customerId + " updated successfully";
            }
        }
        return message;
    }

    @Override
    public String deleteCustomerByCustomerId(String customerId) {
        String message = "";
        Customer foundCustomer = this.customerRepository.findCustomerByCustomerIdentifier(customerId);
        if (foundCustomer == null) {
            message = "Customer with id: " + customerId + " not found in repository.";
        } else {
            this.customerRepository.delete(foundCustomer);
            message = "Customer with id: " + customerId + " deleted successfully";
        }
        return message;
    }

    @Override
    public List<CustomerResponseModel> getCustomersByProductId(String productId) {
        List<Order> orders = orderRepository.findCustomersByProductIdentifier(productId);
        List<CustomerResponseModel> customerResponseModels = new ArrayList<>();
        for (Order order: orders) {
            String customerId = order.getCustomerIdentifier();
            Customer customer = customerRepository.findCustomerByCustomerIdentifier(customerId);
            CustomerResponseModel customerResponseModel = customerResponseMapper.entityToResponseModel(customer);
            customerResponseModels.add(customerResponseModel);
        }
        return customerResponseModels;
    }

}
