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
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
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

        String productId = UUID.randomUUID().toString();
        while (this.productRepository.findProductByProductIdentifier(productId) != null) {
            productId = UUID.randomUUID().toString();
        }
        Product newProduct = this.productRequestMapper.requestModelToEntity(newProductData);
        newProduct.setProductIdentifier(productId);
        this.productRepository.save(newProduct);
        message = "Product saved successfully";

        return message;
    }

    @Override
    public ProductResponseModel getProductByOrderId(String orderId) {
        Order order = orderRepository.findOrderByOrderIdentifier(orderId);
        Product product = productRepository.findProductByProductIdentifier(order.getProductIdentifier());
        return productResponseMapper.entityToResponseModel(product);
    }

    @Override
    public String updateProduct(String productId, ProductRequestModel newProductData) {

        Product foundProduct = productRepository.findProductByProductIdentifier(productId);
        if (foundProduct == null)
            return "Product with " + productId + " not found";

        foundProduct.setName(newProductData.getName());
        foundProduct.setDescription(newProductData.getDescription());
        foundProduct.setSize(newProductData.getSize());
        foundProduct.setPrice(newProductData.getPrice());
        foundProduct.setQuantity(newProductData.getQuantity());
//        foundProduct.setProductStatus(newProductData.getProductStatus());

        productRepository.save(foundProduct);
        return "Product with id: " + productId + " updated successfully";
    }


    @Override
    public String deleteProductByProductId(String productId) {
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
