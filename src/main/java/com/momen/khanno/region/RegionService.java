package com.momen.khanno.region;

import org.springframework.data.domain.Page;

public interface RegionService {

    Region save(Region region);

    Region update(Region region);

    Region getById(long id);

    void delete(Long id);

    Page<Region> getRegions(Integer page, Integer count);

    Page<Region> getRegionsInCity(Long cityId, Integer page, Integer count);

}
