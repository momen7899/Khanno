package com.momen.khanno.region;


import com.momen.khanno.common.PagingData;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/region")
public class RegionController {
    private final RegionService service;
    private final RegionMapper mapper;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        service.save(region);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<RegionDTO> update(@RequestBody RegionDTO regionDTO) {
        Region region = mapper.toRegion(regionDTO);
        RegionDTO savedBefore = mapper.toRegionDTO(service.update(region));
        return ResponseEntity.ok(savedBefore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/paging/{page}/{count}")
    public ResponseEntity<PagingData<RegionDTO>> pagination(@PathVariable Integer page, @PathVariable Integer count) {
        Page<Region> regionPage = service.getRegions(page, count);

        int totalPage = regionPage.getTotalPages();
        List<RegionDTO> cities = mapper.toRegionDTOs(regionPage.getContent());

        PagingData<RegionDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }

    @GetMapping("/paging/{cityId}/{page}/{count}")
    public ResponseEntity<PagingData<RegionDTO>> getRegionsInCity(@PathVariable Integer page, @PathVariable Integer count, @PathVariable Long cityId) {
        Page<Region> regionPage = service.getRegionsInCity(cityId, page, count);

        int totalPage = regionPage.getTotalPages();
        List<RegionDTO> cities = mapper.toRegionDTOs(regionPage.getContent());

        PagingData<RegionDTO> pagingData = new PagingData<>(totalPage, page, cities);

        return ResponseEntity.ok(pagingData);
    }
}
