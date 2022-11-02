package com.cts.ecart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.ecart.entity.Product;
import com.cts.ecart.service.ProductService;

@RestController
@RequestMapping("api/products")
@CrossOrigin
public class SearchServiceResource {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Product findById(@PathVariable int id) {
		return productService.findById(id);
	}

	@GetMapping
	public List<Product> findAll() {
		return productService.findAll();
	}

	@GetMapping("/filter/title/{productTitle}")
	public List<Product> findByProductTitle(@PathVariable String productTitle) {
		// TODO Auto-generated method stub
		return productService.findByProductTitle("%"+productTitle+"%");
	}

	@GetMapping("/filter/price/{startRange}/{endRange}")
	public List<Product> findByPriceRange(@PathVariable double startRange,@PathVariable double endRange) {
		// TODO Auto-generated method stub
		return productService.findByPriceRange(startRange, endRange);
	}

	@GetMapping("/filter/price/greater/{price}")
	public List<Product> findByPriceGreater(@PathVariable double price) {
		// TODO Auto-generated method stub
		return productService.findByPriceGreater(price);
	}

	@GetMapping("/filter/price/lesser/{price}")
	public List<Product> findBypriceLesser(@PathVariable double price) {
		// TODO Auto-generated method stub
		return productService.findBypriceLesser(price);
	}

	@GetMapping("/filter/brand/title/{brandTitle}")
	public List<Product> findByBrandTitle(@PathVariable String brandTitle) {
		// TODO Auto-generated method stub
		return productService.findByBrandTitle(brandTitle);
	}

	@GetMapping("/filter/brand/{brandId}")
	public List<Product> findByBrandId(@PathVariable int brandId) {
		// TODO Auto-generated method stub
		return productService.findByBrandId(brandId);
	}

	@GetMapping("/filter/category/title/{categoryTitle}")
	public List<Product> findByCategoryTitle(@PathVariable String categoryTitle) {
		// TODO Auto-generated method stub
		return productService.findByCategoryTitle(categoryTitle);
	}

	@GetMapping("/filter/category/{categoryId}")
	public List<Product> findByCategoryId(@PathVariable int categoryId) {
		// TODO Auto-generated method stub
		return productService.findByCategoryId(categoryId);
	}
	
	

}
