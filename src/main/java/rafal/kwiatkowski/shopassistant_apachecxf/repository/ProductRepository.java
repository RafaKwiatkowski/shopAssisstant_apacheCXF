package rafal.kwiatkowski.shopassistant_apachecxf.repository;

import org.springframework.stereotype.Repository;
import rafal.kwiatkowski.shopassistant_apachecxf.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    Product findOne(Integer id);

    Product save(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);

    void deleteAll();
}