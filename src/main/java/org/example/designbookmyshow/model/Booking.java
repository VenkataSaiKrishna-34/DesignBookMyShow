package org.example.designbookmyshow.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private Date bookingDate;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;
}
