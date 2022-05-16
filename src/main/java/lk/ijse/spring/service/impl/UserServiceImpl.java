package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        if (!repo.existsById(dto.getUserId())) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public void deleteUser(String uid) {
        if (repo.existsById(uid)) {
            repo.deleteById(uid);
        } else {
            throw new RuntimeException("Please Check the User ID.. No Such Car..!");
        }
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(dto.getUserId())) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("No Such User To Update..! Please Check the ID..!");
        }
    }

    @Override
    public UserDTO searchUser(String uid) {
        if (repo.existsById(uid)) {
            return mapper.map(repo.findById(uid).get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User For " + uid + " ..!");
        }
    }

    @Override
    public List<UserDTO> getAllUser() {
        return mapper.map(repo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }
}