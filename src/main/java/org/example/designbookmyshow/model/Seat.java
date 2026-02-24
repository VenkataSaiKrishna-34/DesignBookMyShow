package org.example.designbookmyshow.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel {
    private int number;
    private int row;
    private int column;
    private SeatType seatType;
}
