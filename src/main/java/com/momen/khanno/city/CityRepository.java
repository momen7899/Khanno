package com.momen.khanno.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findAll(Pageable pageable);

}
