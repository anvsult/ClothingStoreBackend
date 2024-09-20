package org.champsoft.clothingstoreapp.dataMapperLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Product;
import org.champsoft.clothingstoreapp.presentationLayer.ProductResponseModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductResponseMapper {
    List<ProductResponseModel> entityListToResponseModelList(List<Product> products);

    ProductResponseModel entityToResponseModel(Product product);
}
