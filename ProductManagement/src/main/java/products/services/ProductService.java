package products.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import products.model.Product;
import products.repositories.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product register(Product person) {
        productRepository.save(person);
        return person;
    }

    public void unregister(String id) {
        productRepository.deleteById(id);
    }

    public Product findById(String id) {
        return productRepository.findById(id).get();
    }
}
