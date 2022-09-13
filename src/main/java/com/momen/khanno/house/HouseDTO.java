package com.momen.khanno.house;

import com.momen.khanno.common.BaseDTO;
import com.momen.khanno.real_state.LocationDTO;
import com.momen.khanno.real_state.RealState;
import com.momen.khanno.region.Region;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class HouseDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private String title;
    @ApiModelProperty(required = true)
    private String address;
    @ApiModelProperty(required = true)
    private Double area;
    @ApiModelProperty(required = true)
    private Integer numberOfRooms;
    @ApiModelProperty(required = true)
    private Integer constructYear;
    @ApiModelProperty(required = true)
    private Integer numberOfParking;
    @ApiModelProperty(required = true)
    private String description;
    @ApiModelProperty(required = true)
    private LocationDTO location;
    @ApiModelProperty(required = true)
    private HouseType houseType;
    @ApiModelProperty(required = true)
    private DealType dealType;
    private BigDecimal rentPrice;
    private BigDecimal salePrice;
    private BigDecimal mortgagePrice;

    @ApiModelProperty(required = true)
    private List<HouseBenefitsDTO> benefits;

    @ApiModelProperty(required = true)
    private RealState realState;

    @ApiModelProperty(required = true)
    private Region region;
}
