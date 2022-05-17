package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDetailsDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.DriverDetails;
import lk.ijse.spring.repo.DriverDetailsRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.service.DriverDetailsService;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriverDetailsImpl implements DriverDetailsService {

    @Autowired
    private DriverDetailsRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveDriverDetails(DriverDetailsDTO dto) {
        if (!repo.existsById(dto.getDriverId())) {
            repo.save(mapper.map(dto, DriverDetails.class));
        } else {
            throw new RuntimeException("Driver Details Already Exist..!");
        }
    }

    @Override
    public void deleteDriverDetails(String ddid) {
        if (repo.existsById(ddid)) {
            repo.deleteById(ddid);
        } else {
            throw new RuntimeException("Please Check the Driver ID.. No Such Driver..!");
        }
    }

    @Override
    public void updateDriverDetails(DriverDetailsDTO dto) {
        if (repo.existsById(dto.getDriverId())) {
            repo.save(mapper.map(dto, DriverDetails.class));
        } else {
            throw new RuntimeException("No Such Driver To Update..! Please Check the ID..!");
        }
    }

    @Override
    public DriverDetailsDTO searchDriverDetails(String ddid) {
        if (repo.existsById(ddid)) {
            return mapper.map(repo.findById(ddid).get(), DriverDetailsDTO.class);
        } else {
            throw new RuntimeException("No Driver For " + ddid + " ..!");
        }
    }

    @Override
    public List<DriverDetailsDTO> getAllDriverDetails() {
        return mapper.map(repo.findAll(), new TypeToken<List<DriverDetailsDTO>>() {
        }.getType());
    }
}
