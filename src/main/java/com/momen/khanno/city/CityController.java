package com.momen.khanno.city;

import com.momen.khanno.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/city")
@AllArgsConstructor
public class CityController {

    private final CityService service;
    private final CityMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CityDTO> update(@RequestBody CityDTO cityDTO) {
        City city = mapper.toCity(cityDTO);
        CityDTO savedBefore = mapper.toCityDTO(service.update(city));
        return ResponseEntity.ok(savedBefore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingData<CityDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<City> cityPage = service.getCities(page, count);

        int totalPage = cityPage.getTotalPages();
        List<CityDTO> cities = mapper.toCityDTOs(cityPage.getContent());

        PagingData<CityDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

}
