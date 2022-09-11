package com.momen.khanno.region;

import com.momen.khanno.city.City;
import com.momen.khanno.common.BaseEntity;
import com.momen.khanno.house.House;
import com.momen.khanno.real_state.RealState;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "tbl_region")
@Data
@Audited
public class Region extends BaseEntity {

    private String name;
    private Polygon location;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToMany
    private List<RealState> realStates;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "region", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<House> houses;

}
