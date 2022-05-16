package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.BookingDetails;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.BookingDetailsRepo;
import lk.ijse.spring.service.BookingDetailsService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingDetailsImpl implements BookingDetailsService {

    @Autowired
    private BookingDetailsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveBookingDetails(BookingDetailsDTO dto) {
        if (!repo.existsById(dto.getBookingId())) {
            repo.save(mapper.map(dto, BookingDetails.class));
        } else {
            throw new RuntimeException("Booking Already Exist..!");
        }
    }

    @Override
    public void deleteBookingDetails(String bid) {
        if (repo.existsById(bid)) {
            repo.deleteById(bid);
        } else {
            throw new RuntimeException("Please Check the Booking ID.. No Such Booking..!");
        }
    }

    @Override
    public void updateBookingDetails(BookingDetailsDTO dto) {
        if (repo.existsById(dto.getBookingId())) {
            repo.save(mapper.map(dto, BookingDetails.class));
        } else {
            throw new RuntimeException("No Such Booking To Update..! Please Check the ID..!");
        }
    }

    @Override
    public BookingDetailsDTO searchBookingDetails(String bid) {
        if (repo.existsById(bid)) {
            return mapper.map(repo.findById(bid).get(), BookingDetailsDTO.class);
        } else {
            throw new RuntimeException("No Admin For " + bid + " ..!");
        }
    }

    @Override
    public List<BookingDetailsDTO> getAllBookingDetails() {
        return mapper.map(repo.findAll(), new TypeToken<List<BookingDetailsDTO>>() {
        }.getType());
    }
}
