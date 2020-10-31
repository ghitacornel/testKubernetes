package products.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import products.model.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
