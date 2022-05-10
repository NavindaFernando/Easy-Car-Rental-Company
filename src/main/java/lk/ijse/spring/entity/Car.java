package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    private String carId;
    private String carAvailability;
    private String registrationNumber;
    private String carBrand;
    private String carType;
    private String carColor;
    private String carMileage;
    private String carTransmissionType;
    private String carFuelType;
    private int carNumberOfPassengers;
    private double carDailyRate;
    private double carMonthlyRate;
    private double carPriceForExtraKM;
    private double carDamagePrice;
}
