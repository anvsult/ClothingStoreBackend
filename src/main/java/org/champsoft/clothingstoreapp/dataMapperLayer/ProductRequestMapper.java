package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Product;
import org.champsoft.clothingstoreapp.presentationLayer.ProductRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper {
    @Mapping(target = "id", ignore = true)
    Product requestModelToEntity(ProductRequestModel productRequestModel);
}
