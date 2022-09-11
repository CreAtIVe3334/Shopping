package controller;

import Entity.Product;
import Entity.TypeShop;
import Exceptions.ExceptionCustomerNotfound;
import repository.impl.ProductImpl;
import repository.impl.TypeShopImpl;
import repository.inter.ProductInter;
import repository.inter.TypeShopInter;
import services.Impl.ProductServiceIml;
import services.Inter.ProductServiceInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    List<Product> basket = new ArrayList();
    private static TypeShopInter typeShopInter = new TypeShopImpl();
    private static ProductInter productInter = new ProductImpl();
    private static ProductServiceInter productServiceInter=new ProductServiceIml();
    private TypeShop typeShop =null;
    LoginController loginController = new LoginController();
    List<TypeShop> list = typeShopInter.findAll();
    public void productList() throws ExceptionCustomerNotfound {
        System.out.println("Enter your want product type");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println((list.size()+1)+". All product type");
        int k = scanner.nextInt();
        TypeShop typeShop = typeShopInter.findById(k);
        if(typeShop==null){
            productServiceInter.selectAll();
        }else {
            List<Product> productList = productInter.findTypeShop(typeShop);
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i));
            }
        }
        System.out.println("choose your product");
        int n = scanner.nextInt();
        Product product = productInter.findByİd(n);
        if(product==null){
            System.out.println("wrong product");
            loginController.loginThen();
        }else{
        basket.add(product);
        loginController.loginThen();}
    }
    public void showBasket(){
        for (int i = 0; i < basket.size(); i++) {
            System.out.println(basket.get(i));
        }
    }
}
