package controller;

import Exceptions.ExceptionCustomerNotfound;

import java.util.Scanner;

public class MenuController {
    private static Scanner scanner =new Scanner(System.in);
    private static CustomerController customerController=new CustomerController();
    public void menu() throws ExceptionCustomerNotfound {
        System.out.println("Enter function\n1-Registration\n2-Login");
        int n = scanner.nextInt();
        if(n==1){
            customerController.signUp();
        }else if(n==2){
            customerController.login();
        }else {
            System.out.println("wrong function");
        }

    }


}
