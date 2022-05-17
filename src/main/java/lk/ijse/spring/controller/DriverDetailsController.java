package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDetailsDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.DriverDetailsService;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driverdetails")
@CrossOrigin
public class DriverDetailsController {

    @Autowired
    DriverDetailsService driverDetailsService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDriverDetails() {
        return new ResponseUtil(200,"Ok",driverDetailsService.getAllDriverDetails());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriverDetails(@RequestBody DriverDetailsDTO dDetails) {
        driverDetailsService.saveDriverDetails(dDetails);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriverDetails(@RequestBody DriverDetailsDTO dDetails) {
        driverDetailsService.updateDriverDetails(dDetails);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDriverDetails(@RequestParam String id) {
        driverDetailsService.deleteDriverDetails(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{ddid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriverDetails(@RequestParam String ddid) {
        return new ResponseUtil(200,"Ok",driverDetailsService.searchDriverDetails(ddid));
    }
}
