package com.syamsundar.moviebooking.city;

import com.syamsundar.moviebooking.common.entity.BaseEntity;
import com.syamsundar.moviebooking.theatre.Theatre;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cities")
@Getter
@Setter
public class City extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Theatre> theatres;
}
