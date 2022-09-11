package repository.inter;

import Entity.City;

import java.util.List;

public interface CityInter {
    void delete(int id);
    void insert(City city);
    void updateId(City city);

    List<City> findAll();
    City findById(int id);
    City findByName(String name);

}
