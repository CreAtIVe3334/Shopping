package services.Inter;

import Entity.City;

import java.util.List;

public interface CityServiceInter {

    List<City> showAll();
    City findByIdCity(Integer id);
}