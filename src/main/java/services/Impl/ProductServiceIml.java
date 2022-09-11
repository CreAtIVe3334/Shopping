package services.Impl;

import Entity.Product;
import repository.impl.ProductImpl;
import repository.inter.ProductInter;
import services.Inter.ProductServiceInter;

import java.util.List;

public class ProductServiceIml implements ProductServiceInter {
    List<Product> list = null;
    ProductInter productInter = new ProductImpl();
    @Override
    public void selectAll() {
        list = productInter.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }




}
