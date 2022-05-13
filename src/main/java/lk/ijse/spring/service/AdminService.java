package lk.ijse.spring.service;

import lk.ijse.spring.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void saveAdmin(AdminDTO dto);
    void deleteAdmin(String aid);
    void updateAdmin(AdminDTO dto);
    AdminDTO searchAdmin(String aid);
    List<AdminDTO> getAllAdmin();
}
