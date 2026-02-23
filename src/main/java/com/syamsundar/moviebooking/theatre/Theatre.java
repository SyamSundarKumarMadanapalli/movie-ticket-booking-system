package com.syamsundar.moviebooking.theatre;

import com.syamsundar.moviebooking.city.City;
import com.syamsundar.moviebooking.common.entity.BaseEntity;
import com.syamsundar.moviebooking.screen.Screen;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "theatres")
@Getter
@Setter
public class Theatre extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens;
}
