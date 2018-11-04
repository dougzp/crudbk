package com.douglas.example.crudbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.example.crudbk.entities.StoreProduct;
import com.douglas.example.crudbk.exception.StoreProductNotFoundException;
import com.douglas.example.crudbk.service.StoreProductService;

@RestController
public class StoreProductResourceForTest {
	
	
	
	@Autowired
	private StoreProductService service;
	
	
	@GetMapping("/storeProductTest")
	public List<StoreProduct> retrieveAllStoreProductTest() {
		return service.retrieveAllStoreProducts() ;
	}

	@GetMapping("/storeProductTest/{id}")
	public StoreProduct retrieveStudent(@PathVariable long id) throws StoreProductNotFoundException {

		return 	 service.retrieveStoreProduct(id);
	}

	

}
