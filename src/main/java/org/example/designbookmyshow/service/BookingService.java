package org.example.designbookmyshow.service;

import org.example.designbookmyshow.model.*;
import org.example.designbookmyshow.repository.BookingRepository;
import org.example.designbookmyshow.repository.ShowRepository;
import org.example.designbookmyshow.repository.ShowSeatRepository;
import org.example.designbookmyshow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking bookTicket(long userId, long showId, List<Long> showSeatIds) {
        /*
        * 1. Validate user, show and show seats
        * 2. Check if the show seats are available for booking
        * 3. If available, create a booking and update the show seats status to booked
        * 4. Calculate the total amount for the booking
        * 5. The payment should be handled separately by payment service, we can create a payment record with pending status and update it once the payment is successful
        * This payment should be initiated from the client with the booking id
        */

//        1.
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        Optional<Show> showOptional = showRepository.findById(showId);
        if(showOptional.isEmpty()) {
            throw new RuntimeException("Show not found");
        }

//        2.
        List<ShowSeat> showSeats = new ArrayList<>();
        for(long showSeatId : showSeatIds) {
            Optional<ShowSeat> showSeatOptional = showSeatRepository.findById(showSeatId);
            if(showSeatOptional.isEmpty()) {
                throw new RuntimeException("Show seat not found");
            }

            ShowSeat showSeat = showSeatOptional.get();
            if(showSeat.getStatus() != ShowSeatStatus.AVAILABLE) {
                throw new RuntimeException("Show seat not available for booking");
            }
            showSeats.add(showSeat);
        }

//        We should update the show seat status to blocker
        for(ShowSeat showSeat : showSeats) {
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

//        3.
        Booking booking = new Booking();
        booking.setBookingDate(new Date());
        booking.setShow(showOptional.get());
        booking.setUser(userOptional.get());
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPayments(null);

//        do we need to add amount to booking model? or payment service can calculate that?

        return bookingRepository.save(booking);
    }
}
