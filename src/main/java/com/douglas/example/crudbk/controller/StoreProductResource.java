package com.douglas.example.crudbk.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.douglas.example.crudbk.entities.StoreProduct;
import com.douglas.example.crudbk.exception.StoreProductNotFoundException;
import com.douglas.example.crudbk.repository.JpaStoreProductRepository;

@RestController
public class StoreProductResource {
	@Autowired
	private JpaStoreProductRepository storeProductRepository;
	
	@CrossOrigin
	@GetMapping("/storeProducts")
	public List<StoreProduct> retrieveAllStudents() {
		return storeProductRepository.findAll();
	}
	@CrossOrigin
	@GetMapping("/storeProducts/{id}")
	public StoreProduct retrieveStoreProduct(@PathVariable long id) throws StoreProductNotFoundException {
		Optional<StoreProduct> storeProduct = storeProductRepository.findById(id);

		if (!storeProduct.isPresent())
			throw new StoreProductNotFoundException("id-" + id);

		return storeProduct.get();
	}
	@CrossOrigin
	@DeleteMapping("/storeProducts/{id}")
	public void deleteStoreProduct(@PathVariable long id) {
		storeProductRepository.deleteById(id);
	}
	@CrossOrigin
	@PostMapping("/storeProducts")
	public ResponseEntity<Object> createStoreProduct(@RequestBody StoreProduct storeProduct) {
		StoreProduct storedProduct = storeProductRepository.save(storeProduct);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(storedProduct.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	@CrossOrigin
	@PutMapping("/storeProducts/{id}")
	public ResponseEntity<Object> updateStoreProduct(@RequestBody StoreProduct storeProduct, @PathVariable long id) {

		Optional<StoreProduct> storeProductOptional = storeProductRepository.findById(id);

		if (!storeProductOptional.isPresent())
			return ResponseEntity.notFound().build();

		storeProduct.setId(id);
		
		storeProductRepository.save(storeProduct);

		return ResponseEntity.noContent().build();
	}

}
