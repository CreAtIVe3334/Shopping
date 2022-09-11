package repository.inter;

import Entity.Product;
import Entity.TypeShop;

import java.util.List;

public interface ProductInter {
    void insert(Product product);
    Product findByName(String name);
    Product findByİd(int id);
    List<Product> findAll();
    List<Product> findTypeShop(TypeShop typeShop);
    void update(Product product);
    void delete(int id);

}
