package asia.fourtitude.java.sboot.Product.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asia.fourtitude.java.sboot.Product.entity.Product;
import asia.fourtitude.java.sboot.Product.repository.ProductRepository;

@Transactional
@Service
public class ProductService {
	
	@Autowired
	private static ProductRepository productRepository;
	
	public static List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		productRepository.findAll()
		.forEach(productList::add);
		return productList;
	}

	public Product getProduct(String code) {
		return productRepository.findByCode(code);
	}

	public static void addProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(Product product, String code) {
		productRepository.save(product);
	}
	
	public static void deleteProduct(String code) {
		Product p = productRepository.findByCode(code);
		productRepository.delete(p);
	}

	public static Product getProductbyCode(String code) {
		return productRepository.findByCode(code);
	}

}
