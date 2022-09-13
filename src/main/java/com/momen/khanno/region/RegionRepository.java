package com.momen.khanno.region;

import com.momen.khanno.city.City;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RegionRepository extends PagingAndSortingRepository<Region, Long> {

    @NotNull
    Page<Region> findAll(@NotNull Pageable pageable);

    Page<Region> findAllByCity(City city, Pageable pageable);

}
