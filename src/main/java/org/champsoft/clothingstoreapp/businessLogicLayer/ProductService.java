package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.presentationLayer.ProductRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.ProductResponseModel;

import java.util.List;

public interface ProductService {
    ProductResponseModel getProductByOrderId(String orderId);

    String updateProduct(String productId, ProductRequestModel newProductData);

    String deleteProductByProductId(String productId);

    List<ProductResponseModel> getProducts();

    ProductResponseModel getProductById(String productId);

    String addProduct(ProductRequestModel newProductData);

}
