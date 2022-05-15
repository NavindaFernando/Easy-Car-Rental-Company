package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCar(CarDTO dto) {
        if (!repo.existsById(dto.getCarId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public void deleteCar(String cid) {
        if (repo.existsById(cid)) {
            repo.deleteById(cid);
        } else {
            throw new RuntimeException("Please Check the Car ID.. No Such Car..!");
        }
    }

    @Override
    public void updateCar(CarDTO dto) {
        if (repo.existsById(dto.getCarId())) {
            repo.save(mapper.map(dto, Car.class));
        } else {
            throw new RuntimeException("No Such Car To Update..! Please Check the ID..!");
        }
    }

    @Override
    public CarDTO searchCar(String cid) {
        if (repo.existsById(cid)) {
            return mapper.map(repo.findById(cid).get(), CarDTO.class);
        } else {
            throw new RuntimeException("No Car For " + cid + " ..!");
        }
    }

    @Override
    public List<CarDTO> getAllCar() {
        return mapper.map(repo.findAll(), new TypeToken<List<CarDTO>>() {
        }.getType());
    }
}
