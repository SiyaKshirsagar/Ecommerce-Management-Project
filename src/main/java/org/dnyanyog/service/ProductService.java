package org.dnyanyog.service;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.dto.DeleteProductResponse;
import org.dnyanyog.dto.ProductRequest;
import org.dnyanyog.dto.ProductResponse;
import org.dnyanyog.dto.SearchProductResponse;
import org.dnyanyog.dto.UpdateProductRequest;
import org.dnyanyog.dto.UpdateProductResponse;
import org.dnyanyog.entity.Product;
import org.dnyanyog.entity.Users;
import org.dnyanyog.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class ProductService {
   
	@Autowired
	ProductRepo productRepo;
	
	
	public ProductResponse addProduct(ProductRequest request) {
		
		Product productTable =new Product();
		
		productTable.setProduct_name(request.getName());
		productTable.setQuantity(request.getQuantity());
		productTable.setPrice(request.getPrice());
		
		Product dataInsertedInTableIncludingId = productRepo.save(productTable);
		
		ProductResponse response =new ProductResponse();
		
		response.setResponseCode("0000");
		response.setResponseMessage("product added successfully");
		response.setRequest(request);
		
		response.setId(dataInsertedInTableIncludingId.getId());
		
		
		return response;
	}

	
	public UpdateProductResponse updateProduct(Integer id, UpdateProductRequest request) {
	    
	   /* Product productTable = new Product();
	    productTable.setId(id);  // use the id from path
	    productTable.setProduct_name(request.getName());
	    productTable.setQuantity(request.getQuantity());
	    productTable.setPrice(request.getPrice());

	    productRepo.save(productTable);

	    UpdateProductResponse response = new UpdateProductResponse();
	    response.setResponseCode("0000");
	    response.setResponseMessage("product updated successfully");
	    response.setRequest(request);

	    return response;*/
		
		 Product existingProduct = productRepo.findById(id).orElse(null);

		    UpdateProductResponse response = new UpdateProductResponse();

		    if (existingProduct == null) {
		        response.setResponseCode("1001");
		        response.setResponseMessage("Product not found for update");
		        return response;
		    }

		    existingProduct.setProduct_name(request.getName());
		    existingProduct.setQuantity(request.getQuantity());
		    existingProduct.setPrice(request.getPrice());

		    productRepo.save(existingProduct);

		    response.setResponseCode("0000");
		    response.setResponseMessage("Product updated successfully");
		    response.setRequest(request);

		    return response;
	}
	
	
	public SearchProductResponse searchProductById(Integer id) {
		Product product = productRepo.findById(id).orElse(null);

		SearchProductResponse response = new SearchProductResponse();

		if (product == null) {
			response.setResponseCode("1001");
			response.setResponseMessage("Product not found");
		} else {
			response.setResponseCode("0000");
			response.setResponseMessage("Product found successfully");
			response.setId(product.getId());
			response.setName(product.getProduct_name());
			response.setPrice(product.getPrice());
			response.setQuantity(product.getQuantity());
		}

		return response;
	}
	
	
	
	public DeleteProductResponse deleteProductById(Integer id) {

		DeleteProductResponse response = new DeleteProductResponse();

		if (!productRepo.existsById(id)) {
			response.setResponseCode("1002");
			response.setResponseMessage("Product not found for deletion");
			response.setId(id);
			return response;
		}

		productRepo.deleteById(id);

		response.setResponseCode("0000");
		response.setResponseMessage("Product deleted successfully");
		response.setId(id);
		return response;
	}




    
}
