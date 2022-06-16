package com.mateus.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.myfirstproject.entities.Product;
import com.mateus.myfirstproject.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	
	/*Sempre que você instanciar um objeto ProductResource
	 * Ele vai obter para você automaticamente uma instância do CatergoryRepository
	 * Tudo isso debaixo dos panos. Mas para funcionar eu tenho que colocar o @Component (mecanismo de injeção de dependência) 
	 * no ProductRepository */
	@Autowired
	private ProductRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = categoryRepository.findAll(); // Vai buscar todos os dados e devolver para lista e depois eu retorno tudo
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product cat = categoryRepository.findById(id).get();
		return ResponseEntity.ok().body(cat);
	}
}


