package org.example.designbookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {
    @ManyToOne
    private Show show;
    @OneToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus status;
}
