package org.dnyanyog.controller;

import java.util.List;

import org.dnyanyog.dto.DeleteProductResponse;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.dto.SearchProductResponse;
import org.dnyanyog.dto.UpdateProductRequest;
import org.dnyanyog.dto.UpdateProductResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.dto.UserRequest;
import org.dnyanyog.dto.UserResponse;
import org.dnyanyog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product") // Base path for the controller
public class ProductController {

    @Autowired
    ProductService productService;
    
    
    @PostMapping(path ="/AddProduct")
	public ProductResponse addProduct(@RequestBody ProductRequest request) {
		return productService.addProduct(request);
		
	}
	
	
    @PutMapping(path ="/UpdateProduct/{id}")
    public UpdateProductResponse updateProduct(@PathVariable Integer id, @RequestBody UpdateProductRequest request) {
        return productService.updateProduct(id, request);
    }
    
    
    @GetMapping(path ="/searchProduct/{id}")
    public SearchProductResponse searchProduct(@PathVariable Integer id) {
    	return productService.searchProductById(id);
    }
    
    
    @DeleteMapping(path = "/deleteProduct/{id}")
    public DeleteProductResponse deleteProduct(@PathVariable Integer id) {
    	return productService.deleteProductById(id);
    }



    
}
