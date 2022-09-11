package repository.impl;

import Entity.TypeShop;
import repository.inter.TypeShopInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeShopImpl implements TypeShopInter {
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username="postgres";
    String password="3100103";
    @Override
    public void insert(TypeShop typeShop) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            statement.execute("insert into type_shop(type_id, type_name) " +
                    "values ("+typeShop.getTypeId()+",'"+typeShop.getTypeName()+"');");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeShop> findAll() {
        List<TypeShop> list= new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            Statement statement = connection.createStatement();
            statement.execute("select * from type_shop;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                Integer id= resultSet.getInt(1);
                String name = resultSet.getString(2);
                TypeShop typeShop=new TypeShop(id,name);
                list.add(typeShop);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TypeShop findByName(String name) {
        TypeShop typeShop = null;
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type_shop where type_name = ?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                typeShop = new TypeShop(id,name1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return typeShop;
    }

    @Override
    public TypeShop findById(int id) {
        TypeShop typeShop = null;
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement preparedStatement = connection.prepareStatement("select * from type_shop where type_id = ?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                typeShop = new TypeShop(id1,name1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return typeShop;
    }
}
