package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriver(DriverDTO dto) {
        if (!repo.existsById(dto.getDriverId())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("Driver Already Exist..!");
        }
    }

    @Override
    public void deleteDriver(String did) {
        if (repo.existsById(did)) {
            repo.deleteById(did);
        } else {
            throw new RuntimeException("Please Check the Driver ID.. No Such Car..!");
        }
    }

    @Override
    public void updateDriver(DriverDTO dto) {
        if (repo.existsById(dto.getDriverId())) {
            repo.save(mapper.map(dto, Driver.class));
        } else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDTO searchDriver(String did) {
        if (repo.existsById(did)) {
            return mapper.map(repo.findById(did).get(), DriverDTO.class);
        } else {
            throw new RuntimeException("No Car For " + did + " ..!");
        }
    }

    @Override
    public List<DriverDTO> getAllDriver() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDTO>>() {
        }.getType());
    }
}
