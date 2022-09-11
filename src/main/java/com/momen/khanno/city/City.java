package com.momen.khanno.city;


import com.momen.khanno.common.BaseEntity;
import com.momen.khanno.region.Region;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_city")
@Data
@Audited
public class City extends BaseEntity {
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Region> regions;
}
