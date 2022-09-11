package repository.impl;

import Entity.City;
import Entity.Product;
import Entity.TypeShop;
import repository.inter.ProductInter;
import repository.inter.TypeShopInter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductInter {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "3100103";


    @Override
    public void insert(Product product) {
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("insert into product(product_id,product_name,product_count,expired_date,price,fk_product_type_id) " +
                    "values ("+product.getProductId()+",'"+product.getProductName()+"',"+product.getProductCount()+",'"+product.getExpiredTime()+"',"+product.getPrice()+","+product.getTypeShopId().getTypeId()+");");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Product findByName(String name) {
        Product product = null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product where product_name ='"+name+"'; ");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                Integer count = resultSet.getInt(3);
                LocalDate expired = resultSet.getDate(4).toLocalDate();
                Integer price = resultSet.getInt(5);
                Integer type_id1 = resultSet.getInt(6);
                TypeShopInter typeShopInter = new  TypeShopImpl();
                TypeShop typeShop = typeShopInter.findById(type_id1);
                product = new Product(id1,name1,count,expired,price,typeShop);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findByİd(int id) {
        Product product = null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product where product_id ="+id+"; ");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                Integer count = resultSet.getInt(3);
                LocalDate expired = resultSet.getDate(4).toLocalDate();
                Integer price = resultSet.getInt(5);
                Integer type_id1 = resultSet.getInt(6);
                TypeShopInter typeShopInter = new  TypeShopImpl();
                TypeShop typeShop = typeShopInter.findById(type_id1);
                product = new Product(id1,name1,count,expired,price,typeShop);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            statement.execute("select * from product;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                Integer count = resultSet.getInt(3);
                LocalDate expired = resultSet.getDate(4).toLocalDate();
                Integer price = resultSet.getInt(5);
                Integer type_id1 = resultSet.getInt(6);
                TypeShopInter typeShopInter = new  TypeShopImpl();
                TypeShop typeShop = typeShopInter.findById(type_id1);
                Product product = new Product(id1,name1,count,expired,price,typeShop);
                list.add(product);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findTypeShop(TypeShop typeShop) {
        List<Product> list = new ArrayList<>();
        TypeShopInter typeShopInter = new  TypeShopImpl();
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Product product = null;
            Statement statement = connection.createStatement();
            statement.execute("select * from product where fk_product_type_id ="+typeShop.getTypeId()+"; ");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                Integer count = resultSet.getInt(3);
                LocalDate expired = resultSet.getDate(4).toLocalDate();
                Integer price = resultSet.getInt(5);
                Integer type_id1 = resultSet.getInt(6);
                TypeShop typeShop1 = typeShopInter.findById(type_id1);
                product = new Product(id1,name1,count,expired,price,typeShop1);
                list.add(product);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(Product product) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement preparedStatement = connection.prepareStatement("update product set product_name = ? where product_id = ?");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try(Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            statement.execute("delete from product " +
                    "where product_id="+id+";");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
