package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCar() {
        return new ResponseUtil(200,"Ok",carService.getAllCar());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO car) {
        carService.saveCar(car);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO car) {
        carService.updateCar(car);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCar(@RequestParam String id) {
        carService.deleteCar(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{cid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCar(@RequestParam String cid) {
        return new ResponseUtil(200,"Ok",carService.searchCar(cid));
    }
}
