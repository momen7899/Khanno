package com.momen.khanno.house;

import org.springframework.data.domain.Page;

public interface HouseService {
    House save(House house);

    House update(House house);

    House getById(Long id);

    void delete(Long id);

    Page<House> getHouses(Integer page, Integer count);

    Page<House> getHousesInRegion(Long regionId, Integer page, Integer count);

    Page<House> getHousesInCity(Long cityId, Integer page, Integer count);
}
