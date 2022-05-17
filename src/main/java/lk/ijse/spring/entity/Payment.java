package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Payment {
    @Id
    private String paymentId;
    private String carId;
    private String userId;
    private String driverId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dropOffLastDate;
    private double rentPrice;
    private double damagingPrice;
    private double discount;
    private double totalPrice;
}
