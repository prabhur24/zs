package com.zs.entity;

import com.google.gson.Gson;
import com.zs.data.Product;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DbProduct {

	@Id
	@SequenceGenerator(allocationSize = 1, name = "product_sequence", sequenceName = "product_sequence")
	@GeneratedValue(generator = "product_sequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "name", updatable = false)
	private String productName;

	@Column(name = "imageUrl")
	private String imageUrl;

	@Column(name = "details")
	private String details;

	@Column(name = "price", precision = 2, scale = 0)
	private Double price;

	public DbProduct toDbModel(Product product) {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(product), DbProduct.class);
	}

	public Product toDataModel() {
		Gson gson = new Gson();
		return gson.fromJson(gson.toJson(this), Product.class);
	}
}
