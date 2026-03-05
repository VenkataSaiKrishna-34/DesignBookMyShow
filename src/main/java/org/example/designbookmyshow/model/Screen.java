package org.example.designbookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;
    @OneToMany
    private List<Seat> seats;

    @ElementCollection(targetClass = Feature.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(
            name = "screen_features",
            joinColumns = @JoinColumn(name = "screen_id")
    )
    @Column(name = "feature")
    private List<Feature> features;
    @ManyToOne
    private Theatre theatre;
}