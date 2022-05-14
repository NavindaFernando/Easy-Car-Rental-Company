package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarDTO;

import java.util.List;

public interface CarService {
    void saveCar(CarDTO dto);
    void deleteCar(String cid);
    void updateCar(AdminDTO dto);
    AdminDTO searchCar(String cid);
    List<CarDTO> getAllCar();
}
