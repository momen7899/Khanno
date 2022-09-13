package com.momen.khanno.house;

import com.momen.khanno.city.City;
import com.momen.khanno.city.CityService;
import com.momen.khanno.common.exception.NotFoundException;
import com.momen.khanno.real_state.RealState;
import com.momen.khanno.real_state.RealStateService;
import com.momen.khanno.region.Region;
import com.momen.khanno.region.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository repository;
    private final RegionService regionService;
    private final CityService cityService;
    private final RealStateService realStateService;

    @Override
    public House save(House house) {
        return repository.save(house);
    }

    @Override
    public House update(House house) {
        House savedBefore = getById(house.getId());
        savedBefore.setTitle(house.getTitle());
        savedBefore.setAddress(house.getAddress());
        savedBefore.setArea(house.getArea());
        savedBefore.setNumberOfRooms(house.getNumberOfRooms());
        savedBefore.setConstructYear(house.getConstructYear());
        savedBefore.setNumberOfParking(house.getNumberOfParking());
        savedBefore.setDescription(house.getDescription());
        savedBefore.setLocation(house.getLocation());
        savedBefore.setHouseType(house.getHouseType());
        savedBefore.setDealType(house.getDealType());
        savedBefore.setRentPrice(house.getRentPrice());
        savedBefore.setSalePrice(house.getSalePrice());
        savedBefore.setMortgagePrice(house.getMortgagePrice());
        savedBefore.setBenefits(house.getBenefits());
        savedBefore.setRealState(house.getRealState());
        savedBefore.setRegion(house.getRegion());
        return repository.save(savedBefore);
    }

    @Override
    public House getById(Long id) {
        Optional<House> optionalHouse = repository.findById(id);

        if (optionalHouse.isEmpty()) throw new NotFoundException("House Not Found");

        return optionalHouse.get();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<House> getHouses(Integer page, Integer count) {
        return repository.findAll(PageRequest.of(page, count, Sort.by("id").ascending()));
    }

    @Override
    public Page<House> getHousesInRegion(Long regionId, Integer page, Integer count) {
        Region region = regionService.getById(regionId);
        return repository.findAllByRegion(region, PageRequest.of(page, count, Sort.by("id").ascending()));
    }

    @Override
    public Page<House> getHousesInCity(Long cityId, Integer page, Integer count) {
        City city = cityService.getById(cityId);
        return repository.findAllByRegion_City_Id(city.getId(), PageRequest.of(page, count, Sort.by("id").ascending()));
    }

    @Override
    public Page<House> getHousesInRealState(Long realStateId, Integer page, Integer count) {
        RealState realState = realStateService.getById(realStateId);
        return repository.findAllByRegion_City_Id(realState.getId(), PageRequest.of(page, count, Sort.by("id").ascending()));
    }
}
