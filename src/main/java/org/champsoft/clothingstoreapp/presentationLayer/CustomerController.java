package org.champsoft.clothingstoreapp.presentationLayer;

import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerService;
import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("get-customers")
    public List<CustomerResponseModel> getCustomer() {
        return this.customerService.getCustomers();
    }

    @GetMapping("get-customer/{customer_id}")
    public CustomerResponseModel getCustoemrById(@PathVariable String customer_id) {
        return this.customerService.getCustomerById(customer_id);
    }

    @PostMapping("add-customer")
    public String addCustomer(@RequestBody CustomerRequestModel newCustomerData) {
        return this.customerService.addCustomer(newCustomerData);
    }
    @PutMapping("update-customer/{customer_id}")
    public String updateCustomer(@PathVariable String customer_id, @RequestBody CustomerRequestModel newCustomerData){
        return this.customerService.updateCustomer(customer_id, newCustomerData);
    }
    @DeleteMapping("delete-customer/{customer_id}")
    public String deleteCustomer(@PathVariable String customer_id){
        return this.customerService.deleteCustomerByCustomerId(customer_id);
    }

}


