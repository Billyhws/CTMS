package com.ctms.ctms.services;

import com.ctms.ctms.exception.BookNotFoundException;
import com.ctms.ctms.exception.TripNotFoundException;
import com.ctms.ctms.models.Booking;
import com.ctms.ctms.models.BookingStatus;
import com.ctms.ctms.models.Customer;
import com.ctms.ctms.models.Trip;
import com.ctms.ctms.repositories.BookingRepo;
import com.ctms.ctms.repositories.CustomerRepo;
import com.ctms.ctms.repositories.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;
    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private CustomerRepo customerRepo;


    public Booking addBook(Long id,Booking book) {
        Trip trip = tripRepo.findById(id)
                .orElseThrow(() -> new TripNotFoundException("Trip with ID " + id + " not found"));
        book.setTrip(trip);
        return bookingRepo.save(book);
    }

    public Booking updateBook(Long id, Boolean status) {
        Booking book1 = bookingRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Trip with ID " + id + " not found"));
        Customer customer = customerRepo.findById(book1.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if(status) {
            book1.setStatus(BookingStatus.CONFIRMED);
        }
        else {
            book1.setStatus(BookingStatus.CANCELLED);
        }
        customer.setUnreadStatusCount(customer.getUnreadStatusCount() + 1);
        customerRepo.save(customer);
        return bookingRepo.save(book1);
    }

    public String deleteBook(Long id) {

        Booking book = bookingRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));

        bookingRepo.delete(book);
        return "Book with ID " + id + " deleted successfully";
    }

    public Booking getBook(Long id) {
        return bookingRepo.findById(id).orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found"));
    }

    public List<Booking> getAllBooksOfTrip(Long id) {
        List<Booking> books = bookingRepo.findAllByTrip_id(id);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No trips found for agency ID: " + id);
        }
        return books;
    }

    public List<Booking> getAllBooksOfCustomer(Long id) {
        List<Booking> books = bookingRepo.findAllByCustomer_id(id);
        if (books.isEmpty()) {
            throw new BookNotFoundException("No trips found for agency ID: " + id);
        }
        return books;
    }
    public void markStatusAsRead(Long customerId) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setUnreadStatusCount(0);
        customerRepo.save(customer);
    }
}
