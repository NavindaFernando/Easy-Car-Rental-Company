package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUser() {
        return new ResponseUtil(200,"Ok",userService.getAllUser());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveUser(@RequestBody UserDTO user) {
        userService.saveUser(user);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO user) {
        userService.updateUser(user);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteUser(@RequestParam String id) {
        userService.deleteUser(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{uid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUser(@RequestParam String uid) {
        return new ResponseUtil(200,"Ok",userService.searchUser(uid));
    }
}
