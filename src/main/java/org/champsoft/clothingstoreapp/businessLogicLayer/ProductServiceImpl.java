package org.champsoft.clothingstoreapp.businessLogicLayer;

import org.champsoft.clothingstoreapp.dataAccessLayer.Order;
import org.champsoft.clothingstoreapp.dataAccessLayer.OrderRepository;
import org.champsoft.clothingstoreapp.dataAccessLayer.Product;
import org.champsoft.clothingstoreapp.dataAccessLayer.ProductRepository;
import org.champsoft.clothingstoreapp.dataMapperLayer.ProductRequestMapper;
import org.champsoft.clothingstoreapp.dataMapperLayer.ProductResponseMapper;
import org.champsoft.clothingstoreapp.presentationLayer.ProductRequestModel;
import org.champsoft.clothingstoreapp.presentationLayer.ProductResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final ProductResponseMapper productResponseMapper;
    private final ProductRequestMapper productRequestMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, OrderRepository orderRepository, ProductResponseMapper productResponseMapper, ProductRequestMapper productRequestMapper) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.productResponseMapper = productResponseMapper;
        this.productRequestMapper = productRequestMapper;
    }



    @Override
    public List<ProductResponseModel> getProducts() {
        List<Product> products = this.productRepository.findAll();
        return productResponseMapper.entityListToResponseModelList(products);
    }

    @Override
    public ProductResponseModel getProductById(String productId) {
        Product product = this.productRepository.findProductByProductIdentifier(productId);
        return productResponseMapper.entityToResponseModel(product);
    }

    @Override
    public String addProduct(ProductRequestModel newProductData) {
        String message = "";

        String newProductId = newProductData.getProductIdentifier();
        Product foundProduct = this.productRepository.findProductByProductIdentifier(newProductId);
        if (foundProduct != null) {
            message = "Product with " + newProductId + " already exists";
        } else {
            Product newProduct = this.productRequestMapper.requestModelToEntity(newProductData);
            newProduct.setProductIdentifier(newProductId);
            this.productRepository.save(newProduct);
            message = "Product saved successfully";
        }
        return message;
    }

    @Override
    public String updateProduct(String productId, ProductRequestModel newProductData) {
        String message = "";
        Product foundProduct = productRepository.findProductByProductIdentifier(productId);
        if (foundProduct == null) {
            message = "Product with " + productId + " not found";
        } else {
            Product product = productRequestMapper.requestModelToEntity(newProductData);
            product.setProductIdentifier(productId);
            productRepository.save(product);
            message = "Product with id: " + productId + " updated successfully";
        }
        return message;
    }

    @Override
    public String deleteProductByProductId(String productId){
        String message = "";
        Product foundProduct = productRepository.findProductByProductIdentifier(productId);
        if (foundProduct == null) {
            message = "Product with " + productId + " not found";
        } else {
            List<Order> orders = orderRepository.findAllOrdersByProductIdentifier(productId);

            orderRepository.deleteAll(orders);
            productRepository.delete(foundProduct);
            message = "Product with id: " + productId + " and all orders related to it are deleted successfully";
        }
        return message;
    }
}
