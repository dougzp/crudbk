package com.douglas.example.crudbk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.douglas.example.crudbk.entities.StoreProduct;

@Component
public class StoreProductService {
	
	
	
	private static List<StoreProduct> storeProducts= new ArrayList<>();

	static {
		//Initialize Data
		
		StoreProduct java = new StoreProduct(1l,"java8","basics");

		StoreProduct java_second =new StoreProduct(2l,"java article","second ideas");


		storeProducts.add(java);
		storeProducts.add(java_second);
	}

	public List<StoreProduct> retrieveAllStoreProducts() {
		return storeProducts;
	}

	public StoreProduct retrieveStoreProduct(Long sProductId) {
		for (StoreProduct sProduct : storeProducts) {
			if (sProduct.getId().equals(sProductId)) {
				return sProduct;
			}
		}
		return null;
	}



	public StoreProduct StoreProduct(Long sProductId,String name, String description) {
		StoreProduct sProduct = retrieveStoreProduct(sProductId);

		if (sProduct == null) {
			   long generatedLong = new Random().nextLong();
			   sProduct=new StoreProduct(generatedLong, name, description);
		}

		
		
		return sProduct;
	}
	
	

}
