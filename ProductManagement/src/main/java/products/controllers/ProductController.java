package products.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import products.model.Person;
import products.model.Product;
import products.repositories.jsons.ProductJson;
import products.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    final ProductService productService;

    @GetMapping
    public List<ProductJson> findAll() {
        log.info("find all products");
        List<ProductJson> productJsons = new ArrayList<>();
        for (Product product : productService.findAll()) {
            productJsons.add(fromModel(product));
        }
        return productJsons;
    }

    @GetMapping(path = "/{id}")
    public ProductJson findById(@PathVariable("id") String id) {
        log.info("find by id " + id);
        return fromModel(productService.findById(id));
    }

    @PutMapping
    public ProductJson register(@RequestBody ProductJson person) {
        log.info("register " + person);
        return fromModel(productService.register(fromJson(person)));
    }

    @DeleteMapping(path = "/{id}")
    public void unregister(@PathVariable("id") String id) {
        log.info("unregister product with id " + id);
        productService.unregister(id);
    }

    private static Product fromJson(ProductJson productJson) {
        Product product = new Product();
        product.setId(productJson.getId());
        product.setCode(productJson.getCode());
        product.setName(productJson.getName());
        product.setPrice(productJson.getPrice());
        product.setQuantity(productJson.getQuantity());
        product.setPerson(new Person());
        product.getPerson().setId(productJson.getPersonId());
        return product;
    }

    private static ProductJson fromModel(Product product) {
        ProductJson productJson = new ProductJson();
        productJson.setId(product.getId());
        productJson.setCode(product.getCode());
        productJson.setName(product.getName());
        productJson.setPrice(product.getPrice());
        productJson.setQuantity(product.getQuantity());
        productJson.setPersonId(product.getPerson().getId());
        return productJson;
    }
}
