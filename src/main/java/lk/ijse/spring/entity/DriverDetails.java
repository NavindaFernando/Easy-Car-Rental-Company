package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class DriverDetails {
    @Id
    private String driverId;
    private String carId;
    private String driverName;
    private String driverPassword;
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
}
