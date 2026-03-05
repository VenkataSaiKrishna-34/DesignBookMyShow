package org.example.designbookmyshow.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private int number;
    @Column(name = "seat_row")
    private int row;
    @Column(name = "seat_column")
    private int column;
    @ManyToOne
    private SeatType seatType;
}
