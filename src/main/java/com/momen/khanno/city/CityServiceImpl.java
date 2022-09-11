package com.momen.khanno.city;

import com.momen.khanno.common.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository repository;

    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Override
    public City update(City city) {
        City savedBefore = getById(city.getId());
        savedBefore.setName(city.getName());
        return repository.save(savedBefore);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<City> getCities(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page, count, Sort.by("id").ascending()));
    }

    @Override
    public City getById(Long id) {
        Optional<City> optionalCity = repository.findById(id);

        if (optionalCity.isEmpty()) throw new NotFoundException("City Not Found");

        return optionalCity.get();
    }
}
