package com.momen.khanno.real_state;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LocationDTO {
    @ApiModelProperty(required = true)
    private double lat;

    @ApiModelProperty(required = true)
    private double lng;
}
