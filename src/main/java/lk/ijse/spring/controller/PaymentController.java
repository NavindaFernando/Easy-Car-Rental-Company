package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPayment() {
        return new ResponseUtil(200,"Ok",paymentService.getAllPayment());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil savePayment(@RequestBody PaymentDTO payment) {
        paymentService.savePayment(payment);
        return new ResponseUtil(200,"Save",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updatePayment(@RequestBody PaymentDTO payment) {
        paymentService.updatePayment(payment);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletePayment(@RequestParam String id) {
        paymentService.deletePayment(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchPayment(@RequestParam String pid) {
        return new ResponseUtil(200,"Ok",paymentService.searchPayment(pid));
    }
}
