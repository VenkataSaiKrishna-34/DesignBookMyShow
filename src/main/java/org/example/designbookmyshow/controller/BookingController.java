package org.example.designbookmyshow.controller;

import org.example.designbookmyshow.dto.BookTicketRequestDTO;
import org.example.designbookmyshow.dto.BookTicketResponseDTO;
import org.example.designbookmyshow.dto.ResponseStatus;
import org.example.designbookmyshow.model.Booking;
import org.example.designbookmyshow.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO) {
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();

        try {
            Booking booking = bookingService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShowSeatIds());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setShowSeatIds(
                    booking.getShowSeats().stream()
                            .map(showSeat -> showSeat.getId())
                            .toList()
            );

            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setMessage("Booking successful");
        } catch (Exception e) {
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }

        return responseDTO;
    }

}



/*
    Book tickets for a show:
    Request:
    - show id
    - user id
    - showSeat ids list

    Response:
    - booking id
    - booking status (successful, pending, failed)
    - amount
    - show details
    - booked show seats

 */