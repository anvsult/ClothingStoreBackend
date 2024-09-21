package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.presentationLayer.OrderRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.OrderResponseModel;

import java.util.List;

public interface OrderService {
    List<OrderResponseModel> getOrders();

    OrderResponseModel getOrderById(String orderId);

    String addOrder(OrderRequestModel newOrderData);

    String updateOrder(String orderId, OrderRequestModel newOrderData);

    String deleteOrderByOrderId(String orderId);

    List<OrderResponseModel> getOrdersByCustomerId(String customerId);

    List<OrderResponseModel> getOrdersByProductId(String productId);
}
