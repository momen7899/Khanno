package com.momen.khanno.house;

import com.momen.khanno.region.Region;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HouseRepository extends PagingAndSortingRepository<House, Long> {
    @NotNull
    Page<House> findAll(@NotNull Pageable pageable);

    Page<House> findAllByRegion(Region region, Pageable pageable);

    Page<House> findAllByRealState_Id(Long realStateId, Pageable pageable);

    Page<House> findAllByRegion_City_Id(Long cityId, Pageable pageable);
}
