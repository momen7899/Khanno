package com.momen.khanno.image;


import com.momen.khanno.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ImageDTO extends BaseDTO {

    @ApiModelProperty(required = true, hidden = false)
    private String image;
}
