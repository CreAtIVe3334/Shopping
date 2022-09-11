package repository.inter;

import Entity.Customer;
import Entity.OrderShopping;

import java.util.List;

public interface OrderedInter {
    void insert(OrderShopping orderShopping);
    List<OrderShopping> findByCustomer(Customer customer);
    OrderShopping findById(int id);

}
