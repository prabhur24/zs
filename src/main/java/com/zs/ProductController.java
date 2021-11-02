package com.zs;

import com.zs.data.Product;
import com.zs.rest.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductHandler productHandler;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ProductResponse addProduct(@RequestBody @NotNull Product recipe) {
		return productHandler.saveProduct(recipe);
	}


	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ProductResponse updateProduct(@RequestBody @NotNull Product recipe) {
		return productHandler.updateProduct(recipe);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ProductResponse getRecipe(@PathVariable("id") @NotNull Long id) {
		return productHandler.getProductById(id);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ProductResponse listRecipes() {
		return productHandler.listProduct();
	}
}
