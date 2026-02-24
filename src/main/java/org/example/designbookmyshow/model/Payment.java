package org.example.designbookmyshow.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel {
    private Date paymentDate;
    private String trasactionId;
    private double amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Booking booking;
}
