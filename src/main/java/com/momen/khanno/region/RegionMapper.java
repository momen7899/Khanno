package com.momen.khanno.region;

import com.momen.khanno.city.CityMapper;
import com.momen.khanno.house.HouseMapper;
import com.momen.khanno.real_state.RealStateMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class, RealStateMapper.class, HouseMapper.class})
public interface RegionMapper {
    Region toRegion(RegionDTO regionDTO);

    RegionDTO toRegionDTO(Region region);

    List<Region> toRegions(List<RegionDTO> regionDTOS);

    List<RegionDTO> toRegionDTOs(List<Region> regions);
}
