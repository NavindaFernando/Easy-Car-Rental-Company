package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.BookingDetailsDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.BookingDetailsService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
@CrossOrigin
public class BookingDetailsController {

    @Autowired
    BookingDetailsService bookingDetailsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllBooks() {
        return new ResponseUtil(200,"Ok",bookingDetailsService.getAllBookingDetails());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveBookingDetails(@RequestBody BookingDetailsDTO booking) {
        bookingDetailsService.saveBookingDetails(booking);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateBookingDetails(@RequestBody BookingDetailsDTO booking) {
        bookingDetailsService.updateBookingDetails(booking);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteBookingDetails(@RequestParam String id) {
        bookingDetailsService.deleteBookingDetails(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{bid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchBookingDetails(@RequestParam String bid) {
        return new ResponseUtil(200,"Ok",bookingDetailsService.searchBookingDetails(bid));
    }
}
