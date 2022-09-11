package com.momen.khanno.image;

import com.momen.khanno.common.BaseEntity;
import com.momen.khanno.house.House;
import com.momen.khanno.real_state.RealState;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_image")
@Data
@Audited
public class Image extends BaseEntity {

    @NotNull
    @Column(name = "image")
    private String image;

    @OneToOne
    @JoinColumn(name = "real_state_id", unique = true)
    private RealState realState;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private House place;

}
