package com.zs;


import com.zs.data.Product;
import com.zs.entity.DbProduct;
import com.zs.repository.ProductRepository;
import com.zs.rest.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHandler {

	@Autowired
	ProductRepository repository;

	public ProductResponse saveProduct(Product product) {
		ProductResponse response = ProductResponse.builder().build();
		DbProduct dbProduct = new DbProduct().toDbModel(product);
		dbProduct = repository.save(dbProduct);
		response.getProducts().add(dbProduct.toDataModel());
		return response;
	}

	public ProductResponse updateProduct(Product product) {
		return saveProduct(product);
	}


	public ProductResponse listProduct() {
		ProductResponse productResponse = ProductResponse.builder().build();
		List<DbProduct> dbProductList = repository.findAll();
		dbProductList.forEach(product -> {
			productResponse.getProducts().add(product.toDataModel());
		});
		return productResponse;
	}

	public ProductResponse getProductById(Long id) {
		ProductResponse productResponse = ProductResponse.builder().build();
		List<DbProduct> dbProductList = repository.findAll();
		dbProductList.forEach(product -> {
			productResponse.getProducts().add(product.toDataModel());
		});
		return productResponse;
	}

	public ProductResponse getProductByName(String name) {
		ProductResponse productResponse = ProductResponse.builder().build();
		List<DbProduct> dbProductList = repository.findByName(name);
		dbProductList.forEach(product -> {
			productResponse.getProducts().add(product.toDataModel());
		});
		return productResponse;
	}
}
