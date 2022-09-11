package com.momen.khanno.city;


import com.momen.khanno.common.BaseDTO;
import com.momen.khanno.region.RegionDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CityDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String name;

    @ApiModelProperty(hidden = true)
    private List<RegionDTO> regionDTOS;

}
