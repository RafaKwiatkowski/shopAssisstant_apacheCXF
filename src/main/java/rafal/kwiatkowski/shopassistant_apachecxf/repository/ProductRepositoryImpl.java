package rafal.kwiatkowski.shopassistant_apachecxf.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rafal.kwiatkowski.shopassistant_apachecxf.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        String hql = "FROM Product";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Product findOne(Integer id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product save(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public Product update(Integer id, Product productWithChanges) {
        Product product = findOne(id);
        product.setName(productWithChanges.getName());
        product.setQuantity(productWithChanges.getQuantity());
        product.setUnitPrice(productWithChanges.getUnitPrice());
        return save(product);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public void deleteAll() {
        String hql = "delete FROM Product";
        Query query = entityManager.createQuery(hql);
        query.executeUpdate();
    }
}