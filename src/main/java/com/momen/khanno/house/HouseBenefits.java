package com.momen.khanno.house;

import com.momen.khanno.common.BaseEntity;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_place_benefits")
@Data
@Audited
public class HouseBenefits extends BaseEntity {
    private String name;

    @ManyToOne
    @JoinColumn(name = "house_id")
    private House house;

}
