package com.mateus.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateus.myfirstproject.entities.Category;
import com.mateus.myfirstproject.repositories.CategoryRepository;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	
	/*Sempre que você instanciar um objeto CategoryResource
	 * Ele vai obter para você automaticamente uma instância do CatergoryRepository
	 * Tudo isso debaixo dos panos. Mas para funcionar eu tenho que colocar o @Component (mecanismo de injeção de dependência) 
	 * no CategoryRepository */
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll(); // Vai buscar todos os dados e devolver para lista e depois eu retorno tudo
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}
}


