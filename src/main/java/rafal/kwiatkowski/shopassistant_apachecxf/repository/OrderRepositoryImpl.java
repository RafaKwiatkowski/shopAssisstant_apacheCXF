package rafal.kwiatkowski.shopassistant_apachecxf.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import rafal.kwiatkowski.shopassistant_apachecxf.model.OrderTbl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class OrderRepositoryImpl implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<OrderTbl> findAll() {
        String hql = "FROM OrderTbl";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public OrderTbl findOne(Integer id) {
        return entityManager.find(OrderTbl.class, id);
    }

    @Override
    public OrderTbl save(OrderTbl order) {
        entityManager.merge(order);
        return order;
    }

    @Override
    public OrderTbl update(Integer id, OrderTbl order) {
        OrderTbl orderTbl = findOne(id);
        orderTbl.setCustomerId(order.getCustomerId());
        orderTbl.setTotalPrice(order.getTotalPrice());
        orderTbl.setProducts(order.getProducts());
        return save(orderTbl);
    }

    @Override
    public void delete(Integer id) {
        entityManager.remove(findOne(id));
    }

    @Override
    public void deleteAll() {
        String hql = "delete FROM OrderTbl";
        Query query = entityManager.createQuery(hql);
        query.executeUpdate();
    }
}
