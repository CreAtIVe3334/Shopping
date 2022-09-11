package controller;

import Entity.City;
import Entity.Customer;
import Exceptions.ExceptionCustomerNotfound;
import repository.impl.CustomerImpl;
import repository.inter.CustomerInter;
import services.Impl.CityServiceImpl;
import services.Impl.CustomerServicesImpl;
import services.Inter.CityServiceInter;
import services.Inter.CustomerServicesInter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    CustomerInter customerInter = new CustomerImpl();
    private static CityServiceInter cityserviceInter = new CityServiceImpl();
    private static CustomerServicesInter customerserviceInter = new CustomerServicesImpl();
    private static MenuController meniuController=new MenuController();
    private static LoginController loginController = new LoginController();

    public void signUp() throws ExceptionCustomerNotfound{
        System.out.println("Enter id");
        Integer id = scanner.nextInt();
        System.out.println("Enter username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter Surname");
        String surname = scanner.next();
        System.out.println("Enter Birthday");
        String birthdayString = scanner.next();
        LocalDate birthday = LocalDate.parse(birthdayString);
        System.out.println("Enter mail adress");
        String mail = scanner.next();
        System.out.println("Enter money");
        Integer money = scanner.nextInt();
        System.out.println("Enter adress");
        String adress = scanner.next();
        System.out.println("Select city");
        List<City> cities = cityserviceInter.showAll();
        for (int i = 0; i <cities.size() ; i++) {
            System.out.println("      " + cities.get(i));
        }
        int operation = scanner.nextInt();
        City city = cityserviceInter.findByIdCity(operation);
        Customer customer = new Customer(id,username,mail,password,name,surname,birthday,money,adress,city);
        customerserviceInter.registration(customer);
        System.out.println("---------------Succesfully Registration----------------");
        meniuController.menu();

    }
    public void login() throws ExceptionCustomerNotfound {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();
        Customer customer = customerInter.findByUserame(username);
        if(username.equals(customer.getUserName())&&password.equals(customer.getCustPassword())){
            System.out.println("Succesfully login");
            loginController.loginThen();
        }else System.out.println("wrong password");
    }

}