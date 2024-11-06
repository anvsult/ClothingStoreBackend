package org.champsoft.clothingstoreapp.presentationLayer;

import org.champsoft.clothingstoreapp.businessLogicLayer.OrderService;
import org.champsoft.clothingstoreapp.businessLogicLayer.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin(origins = "http://localhost:3000") // Enables CORS for this controller only
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping()
    public List<OrderResponseModel> getOrders() {
        return this.orderService.getOrders();
    }

    @GetMapping("/{order_id}")
    public OrderResponseModel getOrderById(@PathVariable String order_id) {
        return this.orderService.getOrderById(order_id);
    }

    @PostMapping()
    public String addOrder(@RequestBody OrderRequestModel newOrderData) {
        return this.orderService.addOrder(newOrderData);
    }

    @PutMapping("/{order_id}")
    public String updateOrder(@PathVariable String order_id, @RequestBody OrderRequestModel newOrderData) {
        return this.orderService.updateOrder(order_id, newOrderData);
    }

    @DeleteMapping("/{order_id}")
    public String deleteOrder(@PathVariable String order_id) {
        return orderService.deleteOrderByOrderId(order_id);
    }

    ////

    @GetMapping("/customer/{customer_id}")
    public List<OrderResponseModel> getOrdersByCustomerId(@PathVariable String customer_id) {
        return this.orderService.getOrdersByCustomerId(customer_id);
    }

    @GetMapping("product/{product_id}")
    public List<OrderResponseModel> getOrdersByProductId(@PathVariable String product_id) {
        return this.orderService.getOrdersByProductId(product_id);
    }

}


