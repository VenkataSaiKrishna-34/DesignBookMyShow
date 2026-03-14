package org.example.designbookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDTO {
    private long bookingId;
    private List<Long> showSeatIds;
    private ResponseStatus responseStatus;
    private double totalAmount;
    private String message;
}
