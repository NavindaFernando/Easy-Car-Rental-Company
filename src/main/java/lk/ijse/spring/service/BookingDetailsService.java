package lk.ijse.spring.service;

import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface BookingDetailsService {
    void saveBookingDetails(BookingDetailsDTO dto);
    void deleteBookingDetails(String bid);
    void updateBookingDetails(BookingDetailsDTO dto);
    BookingDetailsDTO searchBookingDetails(String bid);
    List<BookingDetailsDTO> getAllBookingDetails();
}
