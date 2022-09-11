package com.momen.khanno.real_state;

import com.momen.khanno.common.BaseDTO;
import com.momen.khanno.image.Image;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RealStateDTO extends BaseDTO {
    @ApiModelProperty(required = true)
    private String name;
    @ApiModelProperty(required = true)
    private String ownerName;
    @ApiModelProperty(required = true)
    private String activityRegion;
    @ApiModelProperty(required = true)
    private String address;
    @ApiModelProperty(required = true)
    private String number;
    @ApiModelProperty(required = true)
    private String details;
    @ApiModelProperty(required = true)
    private LocationDTO location;

    @ApiModelProperty(required = true)
    private Image logo;
}
