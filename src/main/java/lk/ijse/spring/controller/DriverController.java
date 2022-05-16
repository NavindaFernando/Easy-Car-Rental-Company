package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriver() {
        return new ResponseUtil(200,"Ok",driverService.getAllDriver());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO driver) {
        driverService.saveDriver(driver);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driver) {
        driverService.updateDriver(driver);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriver(@RequestParam String id) {
        driverService.deleteDriver(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{did}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@RequestParam String did) {
        return new ResponseUtil(200,"Ok",driverService.searchDriver(did));
    }
}
