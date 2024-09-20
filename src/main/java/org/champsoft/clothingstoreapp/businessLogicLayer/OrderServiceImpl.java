package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Customer;
import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.dataAccessLayer.OrderRepository;
import org.champsoft.clothingstoreapp.dataMapperLayer.OrderRequestMapper;
import org.champsoft.clothingstoreapp.dataMapperLayer.OrderResponseMapper;
import org.champsoft.clothingstoreapp.presentationLayer.OrderRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.OrderResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderResponseMapper orderResponseMapper;
    private final OrderRequestMapper orderRequestMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderResponseMapper orderResponseMapper, OrderRequestMapper orderRequestMapper) {
        this.orderRepository = orderRepository;
        this.orderResponseMapper = orderResponseMapper;
        this.orderRequestMapper = orderRequestMapper;
    }

    @Override
    public List<OrderResponseModel> getOrders() {
        List<Order> orders = this.orderRepository.findAll();
        return orderResponseMapper.entityListToResponseModelList(orders);
    }

    @Override
    public OrderResponseModel getOrderById(String orderId) {
        Order order = orderRepository.findOrderByOrderIdentifier(orderId);
        return orderResponseMapper.entityToResponseModel(order);
    }

    @Override
    public String addOrder(OrderRequestModel newOrderData) {
        String message = "";
        String orderId = newOrderData.getOrderIdentifier();
        Order foundOrder = orderRepository.findOrderByOrderIdentifier(orderId);
        if (foundOrder != null){
            message = "Order with " + orderId + " already exists";
        } else {
            Order order = orderRequestMapper.requestModelToEntity(newOrderData);
            order.setOrderIdentifier(orderId);
            this.orderRepository.save(order);
            message = "Order with " + orderId + " saved successfully";
        }
        return message;
    }

    @Override
    public String updateOrder(String orderId, OrderRequestModel newOrderData) {
        String message = "";
        Order foundOrder = orderRepository.findOrderByOrderIdentifier(orderId);
        if (foundOrder == null){
            message = "Order with " + orderId + " not found";
        } else {
            Order order = orderRequestMapper.requestModelToEntity(newOrderData);
            order.setOrderIdentifier(orderId);
            order.setId(foundOrder.getId());
            this.orderRepository.save(order);
            message = "Order with id : " + orderId + " updated successfully";
        }
        return message;
    }

    @Override
    public String deleteOrderByOrderId(String orderId) {
        String message = "";
        Order foundOrder = orderRepository.findOrderByOrderIdentifier(orderId);
        if (foundOrder == null){
            message = "Order with " + orderId + " not found";
        } else {
            orderRepository.delete(foundOrder);
            message = "Order with id : " + orderId + " deleted successfully";
        }
        return message;
    }
}
