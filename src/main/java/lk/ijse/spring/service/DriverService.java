package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;

import java.util.List;

public interface DriverService {
    void saveDriver(DriverDTO dto);
    void deleteDriver(String did);
    void updateDriver(DriverDTO dto);
    DriverDTO searchDriver(String did);
    List<DriverDTO> getAllDriver();
}
