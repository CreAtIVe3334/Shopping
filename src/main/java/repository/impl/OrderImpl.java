package repository.impl;

import Entity.Customer;
import Entity.OrderShopping;
import Entity.Product;
import Entity.TypeShop;
import repository.inter.CustomerInter;
import repository.inter.OrderedInter;
import repository.inter.ProductInter;
import repository.inter.TypeShopInter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderedInter {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "3100103";


    @Override
    public void insert(OrderShopping orderShopping) {
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("insert into ordered(order_id, total_price, fk_costumer_id, fk_product_id, order_date) " +
                    "values ("+orderShopping.getOrderId()+","+orderShopping.getTotal_price()+","+orderShopping.getCustomer_id().getCustId()+", " +orderShopping.getProduct_id().getTypeShopId()+", '"+orderShopping.getOrderTime()+"')");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderShopping> findByCustomer(Customer customer) {
        List<OrderShopping> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            statement.execute("select * from ordered where fk_costumer_id= "+customer.getCustId()+";");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                Integer price = resultSet.getInt(2);
                Integer custumer_id = resultSet.getInt(3);
                CustomerInter customerInter = new CustomerImpl();
                Customer customer1=customerInter.findByid(custumer_id);
                Integer product_id = resultSet.getInt(4);
                ProductInter productInter = new ProductImpl();
                Product product = productInter.findByİd(product_id);
                LocalDate localDate = resultSet.getDate(5).toLocalDate();
                OrderShopping orderShopping = new OrderShopping(id1,price,customer1,product,localDate);
                list.add(orderShopping);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public OrderShopping findById(int id) {
        OrderShopping orderShopping = null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from ordered where order_id = "+id+"; ");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                Integer price = resultSet.getInt(2);
                Integer custumer_id = resultSet.getInt(3);
                CustomerInter customerInter = new CustomerImpl();
                Customer customer1=customerInter.findByid(custumer_id);
                Integer product_id = resultSet.getInt(4);
                ProductInter productInter = new ProductImpl();
                Product product = productInter.findByİd(product_id);
                LocalDate localDate = resultSet.getDate(5).toLocalDate();
                orderShopping = new OrderShopping(id1,price,customer1,product,localDate);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orderShopping;
    }
}
