package com.zs.rest;

import com.zs.data.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class ProductResponse {
	private List<Product> products;

	public List<Product> getProducts() {
		if (products == null || products.isEmpty()) {
			products = new ArrayList<>();
		}
		return products;
	}
}
