package repository.inter;

import Entity.Product;
import Entity.TypeShop;

import java.util.List;

public interface TypeShopInter {
    void insert(TypeShop typeShop);
    List<TypeShop> findAll();
    TypeShop findByName(String name);
    TypeShop findById(int id);
}
