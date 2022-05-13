package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.entity.Admin;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveAdmin(AdminDTO dto) {
        if (!repo.existsById(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public void deleteAdmin(String aid) {
        if (repo.existsById(aid)) {
            repo.deleteById(aid);
        } else {
            throw new RuntimeException("Please Check the Admin ID.. No Such Admin..!");
        }
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if (repo.existsById(dto.getAdminId())) {
            repo.save(mapper.map(dto, Admin.class));
        } else {
            throw new RuntimeException("No Such Admin To Update..! Please Check the ID..!");
        }
    }

    @Override
    public AdminDTO searchAdmin(String aid) {
        if (repo.existsById(aid)) {
            return mapper.map(repo.findById(aid).get(), AdminDTO.class);
        } else {
            throw new RuntimeException("No Admin For " + aid + " ..!");
        }
    }

    @Override
    public List<AdminDTO> getAllAdmin() {
        return mapper.map(repo.findAll(), new TypeToken<List<AdminDTO>>() {
        }.getType());
    }
}
