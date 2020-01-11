package ar.net.mgardos.vsfridge.core;

import lombok.Getter;

@Getter
public class Product {
	private String name;
	private String code;
	private ProductImage image;

	public void addImage(ProductImage image) {

	}
}
