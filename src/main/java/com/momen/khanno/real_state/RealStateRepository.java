package com.momen.khanno.real_state;

import com.momen.khanno.city.City;
import com.momen.khanno.house.House;
import com.momen.khanno.region.Region;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface RealStateRepository extends PagingAndSortingRepository<RealState, Long> {
    @NotNull
    Page<RealState> findAll(@NotNull Pageable pageable);
}
