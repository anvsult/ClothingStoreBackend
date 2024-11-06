package org.champsoft.clothingstoreapp.presentationLayer;

import org.champsoft.clothingstoreapp.businessLogicLayer.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:3000") // Enables CORS for this controller only
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<ProductResponseModel> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{product_id}")
    public ProductResponseModel getProductById(@PathVariable String product_id) {
        return productService.getProductById(product_id);
    }

    @DeleteMapping("/{product_id}")
    public String deleteProductById(@PathVariable String product_id) {
        return productService.deleteProductByProductId(product_id);
    }

    @PostMapping()
    public String addProduct(@RequestBody ProductRequestModel newProductData) {
        return productService.addProduct(newProductData);
    }

    @PutMapping("/{product_id}")
    public String updateProduct(@PathVariable String product_id, @RequestBody ProductRequestModel newProductData) {
        return productService.updateProduct(product_id, newProductData);
    }

    @GetMapping("/order/{order_id}")
    public ProductResponseModel getProductByOrderId(@PathVariable String order_id) {
        return productService.getProductByOrderId(order_id);
    }

}
