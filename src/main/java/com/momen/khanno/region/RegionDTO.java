package com.momen.khanno.region;

import com.momen.khanno.city.CityDTO;
import com.momen.khanno.common.BaseDTO;
import com.momen.khanno.house.HouseDTO;
import com.momen.khanno.real_state.RealStateDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.awt.*;
import java.util.List;

@Data
public class RegionDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private Polygon location;

    @ApiModelProperty(required = true)
    private CityDTO city;

    @ApiModelProperty(hidden = true)
    private List<RealStateDTO> realStates;

    @ApiModelProperty(hidden = true)
    private List<HouseDTO> houses;
}
