package org.example.designbookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private long userId;
    private long showId;
    private List<Long> showSeatIds;
}
