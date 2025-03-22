package com.devsuperior.demo.dto;

import com.devsuperior.demo.entities.Product;

public class ProductDTO {

	// Atributos de Classe
	private Long id;
	private String name;


	// Construtores
	public ProductDTO() {
	}

	public ProductDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
	}


	// Getters
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
