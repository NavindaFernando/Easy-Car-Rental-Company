package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BookingDetailsDTO {
    private String bookingId;
    private String customerId;
    private String carId;
    private String driverId;
    private String pickUp;
    private String dropOff;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffDate;
    @JsonFormat(pattern = "HH-mm-ss")
    private LocalTime pickUpTime;
    @JsonFormat(pattern = "HH-mm-ss")
    private LocalTime dropOffTime;
    private double rentPrice;
}