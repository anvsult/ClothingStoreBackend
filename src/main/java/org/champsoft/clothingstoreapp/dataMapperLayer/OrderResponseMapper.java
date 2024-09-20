package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.presentationLayer.OrderResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderResponseMapper {

    List<OrderResponseModel> entityListToResponseModelList(List<Order> orders);

    OrderResponseModel entityToResponseModel(Order order);
}
