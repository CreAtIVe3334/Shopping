package repository.impl;

import java.time.LocalDate;
import Entity.City;
import Entity.Customer;
import Exceptions.ExceptionCustomerNotfound;
import repository.inter.CityInter;
import repository.inter.CustomerInter;

import java.sql.*;

public class CustomerImpl implements CustomerInter {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "3100103";
    @Override
    public void insert(Customer customer) {
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("insert into costumer(cost_id, username, email, cost_password, cost_name, cost_surname, cost_birthday,cost_money,adress, fk_city_id) " +
                    "values ("+customer.getCustId()+",'"+customer.getUserName()+"','"+customer.getEmail()+"','"+customer.getCustPassword()+"','"+customer.getCustName()+"','"+customer.getCustSurname()+"','"+customer.getCustBirth()+"','"+customer.getCustMoney()+"','"+customer.getAdress()+"',"+customer.getCityIdFk().getCityId()
                    +");");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer findByid(int id) {
        Customer customer=null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer where cost_id="+id+";");
            ResultSet resultSet= statement.getResultSet();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String user1 = resultSet.getString(2);
                String email= resultSet.getString(3);
                String password = resultSet.getString(4);
                String  name = resultSet.getString(5);
                String surName = resultSet.getString(6);
                LocalDate birth =resultSet.getDate(7).toLocalDate();
                Integer money = resultSet.getInt(8);
                String addres = resultSet.getString(9);
                Integer city1 = resultSet.getInt(10);

                CityInter cityInter=new CityImpl();
                City city2=cityInter.findById(city1);
                customer = new Customer(id1,user1,email,password,name,surName,birth,money,addres,city2);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public Customer findByUserame(String name) throws ExceptionCustomerNotfound{
        Customer customer=null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer where username='"+name+"';");
            ResultSet resultSet= statement.getResultSet();
            CityInter cityInter = new CityImpl();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String user1 = resultSet.getString(2);
                String email= resultSet.getString(3);
                String password = resultSet.getString(4);
                String  name1 = resultSet.getString(5);
                String surName = resultSet.getString(6);
                LocalDate birth =resultSet.getDate(7).toLocalDate();
                Integer money = resultSet.getInt(8);
                String addres = resultSet.getString(9);
                Integer city1 = resultSet.getInt(10);
                City city2 = cityInter.findById(city1);
                customer = new Customer(id1,user1,email,password,name1,surName,birth,money,addres,city2);

            }

        }catch (SQLException e){
            e.printStackTrace();

        }
        if(customer==null){
            throw new ExceptionCustomerNotfound("Customer not found");
        }
        return customer;
    }

    @Override
    public Customer findByCity(City city) {
        Customer customer=null;
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer where fk_city_id="+city.getCityId()+";");
            ResultSet resultSet= statement.getResultSet();
            CityInter cityInter = new CityImpl();

            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String user1 = resultSet.getString(2);
                String email= resultSet.getString(3);
                String password = resultSet.getString(4);
                String  name1 = resultSet.getString(5);
                String surName = resultSet.getString(6);
                LocalDate birth =resultSet.getDate(7).toLocalDate();
                Integer money = resultSet.getInt(8);
                String addres = resultSet.getString(9);
                Integer city1 = resultSet.getInt(10);


                City city2 = cityInter.findById(city1);

                customer = new Customer(id1,user1,email,password,name1,surName,birth,money,addres,city2);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return customer;
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = DriverManager.getConnection(url,username,password)){
            PreparedStatement preparedStatement = connection.prepareStatement("update costumer set username = ? where cost_id = ?");
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setInt(2, customer.getCustId());
            preparedStatement.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
