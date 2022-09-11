package com.momen.khanno.house;

import com.momen.khanno.common.BaseEntity;
import com.momen.khanno.real_state.RealState;
import com.momen.khanno.region.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tbl_house")
@Data
@Audited
public class House extends BaseEntity {

    private String title;
    private String address;
    private Double area;
    private Integer numberOfRooms;
    private Integer constructYear;
    private Integer numberOfParking;
    private String description;
    private Point<G2D> location;
    private HouseType houseType;
    private DealType dealType;
    private BigDecimal rentPrice;
    private BigDecimal salePrice;
    private BigDecimal mortgagePrice;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "house", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<HouseBenefits> benefits;

    @ManyToOne
    @JoinColumn(name = "real_state_id")
    private RealState realState;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;


}
