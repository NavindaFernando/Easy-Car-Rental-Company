package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200,"Ok",adminService.getAllAdmin());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveAdmin(@RequestBody AdminDTO admin) {
        adminService.saveAdmin(admin);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateAdmin(@RequestBody AdminDTO admin) {
        adminService.updateAdmin(admin);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteAdmin(@RequestParam String id) {
        adminService.deleteAdmin(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{aid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAdmin(@RequestParam String aid) {
        return new ResponseUtil(200,"Ok",adminService.searchAdmin(aid));
    }
}

