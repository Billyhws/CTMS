package com.ctms.ctms.services;
import com.ctms.ctms.models.Booking;
import com.ctms.ctms.models.BookingStatus;
import com.ctms.ctms.models.Trip;
import com.ctms.ctms.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompletedStatusService {
    @Autowired
    private BookingRepo bookingRepo;

    @Scheduled(fixedRate = 3600000)
    public void updateCompletedTrips() {
        List<Booking> books = bookingRepo.findAll();

        for (Booking aBook : books ) {
            Trip trip = aBook.getTrip();

            if (trip.getLastTripDate() != null &&
                    trip.getLastTripDate().isBefore(LocalDate.now()) &&
                    aBook.getStatus() != BookingStatus.COMPLETED) {

                aBook.setStatus(BookingStatus.COMPLETED);
                bookingRepo.save(aBook);
            }
        }
    }
}
