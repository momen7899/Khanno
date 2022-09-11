package com.momen.khanno.city;


import org.springframework.data.domain.Page;

public interface CityService {

    City save(City city);

    City update(City city);

    City getById(Long id);

    void delete(Long id);

    Page<City> getCities(Integer page, Integer count);

}
