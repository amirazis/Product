package asia.fourtitude.java.sboot.Product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asia.fourtitude.java.sboot.Product.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	Product findByCode(String code);

}
