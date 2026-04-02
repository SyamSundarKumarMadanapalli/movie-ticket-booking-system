package com.syamsundar.moviebooking.movie;

import com.syamsundar.moviebooking.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "movies",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_movie_title", columnNames = {"title"})
        }
)
@Getter
@Setter
public class Movie extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer durationInMinutes;

    @Column(nullable = false)
    private String language;
}
