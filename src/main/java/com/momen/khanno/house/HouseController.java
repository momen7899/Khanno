package com.momen.khanno.house;

import com.momen.khanno.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/house")
public class HouseController {
    private final HouseService service;
    private final HouseMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        service.save(house);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<HouseDTO> update(@RequestBody HouseDTO houseDTO) {
        House house = mapper.toHouse(houseDTO);
        HouseDTO savedBefore = mapper.toHouseDTO(service.update(house));
        return ResponseEntity.ok(savedBefore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingData<HouseDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<House> regionPage = service.getHouses(page, count);

        int totalPage = regionPage.getTotalPages();
        List<HouseDTO> cities = mapper.toHouseDTOs(regionPage.getContent());

        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/paging/city/{cityId}/{page}/{count}")
    public ResponseEntity<PagingData<HouseDTO>> getRegionsInCity(@PathVariable Integer page, @PathVariable Integer count, @PathVariable Long cityId) {
        Page<House> regionPage = service.getHousesInCity(cityId, page, count);

        int totalPage = regionPage.getTotalPages();
        List<HouseDTO> cities = mapper.toHouseDTOs(regionPage.getContent());

        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/paging/region/{regionId}/{page}/{count}")
    public ResponseEntity<PagingData<HouseDTO>> getRegionsInRegion(@PathVariable Integer page, @PathVariable Integer count, @PathVariable Long regionId) {
        Page<House> regionPage = service.getHousesInRegion(regionId, page, count);

        int totalPage = regionPage.getTotalPages();
        List<HouseDTO> cities = mapper.toHouseDTOs(regionPage.getContent());

        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/paging/region/{realStateId}/{page}/{count}")
    public ResponseEntity<PagingData<HouseDTO>> getHouseInRealState(@PathVariable Integer page, @PathVariable Integer count, @PathVariable Long realStateId) {
        Page<House> realState = service.getHousesInRealState(realStateId, page, count);

        int totalPage = realState.getTotalPages();
        List<HouseDTO> cities = mapper.toHouseDTOs(realState.getContent());

        PagingData<HouseDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

}
