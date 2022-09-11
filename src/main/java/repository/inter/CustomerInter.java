package repository.inter;

import Entity.City;
import Entity.Customer;
import Exceptions.ExceptionCustomerNotfound;

public interface CustomerInter {
    void insert(Customer customer);

    Customer findByid(int id);

    Customer findByUserame(String name) throws ExceptionCustomerNotfound;

    Customer findByCity(City city);

    void update(Customer customer);


}
