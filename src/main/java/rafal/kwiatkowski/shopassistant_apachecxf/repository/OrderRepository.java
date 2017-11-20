package rafal.kwiatkowski.shopassistant_apachecxf.repository;

import rafal.kwiatkowski.shopassistant_apachecxf.model.OrderTbl;

import java.util.List;

public interface OrderRepository {
    List<OrderTbl> findAll();

    OrderTbl findOne(Integer id);

    OrderTbl save(OrderTbl order);

    OrderTbl update(Integer id, OrderTbl order);

    void delete(Integer id);

    void deleteAll();
}
