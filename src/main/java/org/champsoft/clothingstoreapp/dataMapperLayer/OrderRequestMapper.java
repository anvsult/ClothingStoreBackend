package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.presentationLayer.OrderRequestModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRequestMapper {
    Order requestModelToEntity(OrderRequestModel orderRequestModel);
}
