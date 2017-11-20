package rafal.kwiatkowski.shopassistant_apachecxf.repository;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rafal.kwiatkowski.shopassistant_apachecxf.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
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

    @Override
    public List<Product> findByName(String name) {
        String hql = "FROM Product p where p.name = '" + name + "'";
        return entityManager.createQuery(hql).getResultList();
    }

}