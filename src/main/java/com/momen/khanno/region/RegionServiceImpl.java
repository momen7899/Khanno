package com.momen.khanno.region;

import com.momen.khanno.city.City;
import com.momen.khanno.city.CityService;
import com.momen.khanno.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final CityService cityService;
    private final RegionRepository repository;

    @Override
    public Region save(Region region) {
        return repository.save(region);
    }

    @Override
    public Region update(Region region) {
        Region savedBefore = getById(region.getId());
        savedBefore.setName(region.getName());
        savedBefore.setCity(region.getCity());
        return repository.save(savedBefore);
    }

    @Override
    public Region getById(long id) {
        Optional<Region> optionalRegion = repository.findById(id);

        if (optionalRegion.isEmpty()) throw new NotFoundException("Region not found");

        return optionalRegion.get();
    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Region> getRegions(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page, count, Sort.by("id").ascending()));
    }

    @Override
    public Page<Region> getRegionsInCity(Long cityId, Integer page, Integer count) {
        City city = cityService.getById(cityId);
        return repository.findAllByCity(city, PageRequest.of(page, count, Sort.by("id").ascending()));
    }

}
