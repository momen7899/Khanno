package com.momen.khanno.house;

import com.momen.khanno.city.City;
import com.momen.khanno.region.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
    Page<House> findAll(Pageable pageable);

    Page<House> findAllByRegion(Region region, Pageable pageable);

    Page<House> findAllByRegion_City(City city, Pageable pageable);
}
