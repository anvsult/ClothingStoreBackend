package org.champsoft.clothingstoreapp.presentationLayer;

import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerService;
import org.champsoft.clothingstoreapp.businessLogicLayer.CustomerServiceImpl;
import org.champsoft.clothingstoreapp.businessLogicLayer.OrderService;
import org.champsoft.clothingstoreapp.businessLogicLayer.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
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

    @PostMapping("/add-order")
    public String addOrder(@RequestBody OrderRequestModel newOrderData) {
        return this.orderService.addOrder(newOrderData);
    }
    @PutMapping("/{order_id}")
    public String updateOrder(@PathVariable String order_id, @RequestBody OrderRequestModel newOrderData){
        return this.orderService.updateOrder(order_id, newOrderData);
    }
    @DeleteMapping("delete-order/{order_id}")
    public String deleteOrder(@PathVariable String order_id){
        return orderService.deleteOrderByOrderId(order_id);
    }

}


