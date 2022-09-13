package com.momen.khanno.city;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {

    Page<City> findAll(@NotNull Pageable pageable);

}
