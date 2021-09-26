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
	private ProductRepository productRepository;
	
	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		productRepository.findAll()
		.forEach(productList::add);
		return productList;
	}

	public Product getProduct(String code) {
		return productRepository.findByCode(code);
	}

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void updateProduct(Product product, String code) {
		productRepository.save(product);
	}
	
	public void deleteProduct(String code) {
		Product p = productRepository.findByCode(code);
		productRepository.delete(p);
	}

	public Product getProductbyCode(String code) {
		return productRepository.findByCode(code);
	}

}
