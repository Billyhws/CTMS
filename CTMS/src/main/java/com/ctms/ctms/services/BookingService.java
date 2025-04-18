package com.ctms.ctms.services;

import com.ctms.ctms.exception.BookNotFoundException;
import com.ctms.ctms.models.Booking;
import com.ctms.ctms.repositories.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;


    public Booking addBook(Booking book) {
        return bookingRepo.save(book);
    }

    public Booking updateBook(Long id, Booking book) {
        Booking book1 = bookingRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Trip with ID " + id + " not found"));

        book1.setBookingDate(book.getBookingDate());
        book1.setTrip_id(book.getTrip_id());
        book1.setStatus(book.getStatus());

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
}
