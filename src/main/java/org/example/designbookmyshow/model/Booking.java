package org.example.designbookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel {
    private Date bookingDate;
    private Show show;
    private List<ShowSeat> showSeats;
    private User user;
    private List<Payment> payments;
    private BookingStatus bookingStatus;
}
