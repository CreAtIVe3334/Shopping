package controller;

import Exceptions.ExceptionCustomerNotfound;

import java.util.Scanner;

public class LoginController {
    private static Scanner scanner= new Scanner(System.in);
    private static ProductController productController = new ProductController();
    private static MenuController menuController = new MenuController();
    public void loginThen() throws ExceptionCustomerNotfound {
        System.out.println("1.Buy product\n" +
                "2.Show Basket\n" +
                "3.Show Information\n" +
                "4.Log out");
        int k = scanner.nextInt();
        if(k==1){
          productController.productList();
        }else if (k==2){
            productController.showBasket();
            System.out.println("1.Buy\n" +
                    "3.Clear");

        } else if (k==3) {

        } else if (k==4) {
            menuController.menu();
        }


    }

}
