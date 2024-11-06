package org.champsoft.clothingstoreapp.presentationLayer;

import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerService;
import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@CrossOrigin(origins = "http://localhost:3000") // Enables CORS for this controller only
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerResponseModel> getCustomer() {
        return this.customerService.getCustomers();
    }

    @GetMapping("/{customer_id}")
    public CustomerResponseModel getCustomerById(@PathVariable String customer_id) {
        return this.customerService.getCustomerById(customer_id);
    }

    @PostMapping()
    public String addCustomer(@RequestBody CustomerRequestModel newCustomerData) {
        return this.customerService.addCustomer(newCustomerData);
    }

    @PutMapping("/{customer_id}")
    public String updateCustomer(@PathVariable String customer_id, @RequestBody CustomerRequestModel newCustomerData) {
        return this.customerService.updateCustomer(customer_id, newCustomerData);
    }

    @DeleteMapping("/{customer_id}")
    public String deleteCustomer(@PathVariable String customer_id) {
        return this.customerService.deleteCustomerByCustomerId(customer_id);
    }

    @GetMapping("/product/{product_id}")
    public List<CustomerResponseModel> getCustomersByProductId(@PathVariable String product_id) {
        return this.customerService.getCustomersByProductId(product_id);
    }
}


