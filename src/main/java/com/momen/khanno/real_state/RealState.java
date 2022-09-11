package com.momen.khanno.real_state;


import com.momen.khanno.common.BaseEntity;
import com.momen.khanno.house.House;
import com.momen.khanno.image.Image;
import com.momen.khanno.region.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_real_state")
@Data
@Audited
public class RealState extends BaseEntity {

    private String name;
    private String ownerName;
    private String activityRegion;
    private String address;
    private String number;
    private String details;
    private Point<G2D> location;

    @OneToOne
    @JoinColumn(name = "image_id", unique = true)
    private Image logo;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "realState", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;


    @ManyToMany
    private List<Region> regions;
}
