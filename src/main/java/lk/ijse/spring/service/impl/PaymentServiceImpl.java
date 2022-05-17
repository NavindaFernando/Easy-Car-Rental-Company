package lk.ijse.spring.service.impl;


import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void savePayment(PaymentDTO dto) {
        if (!repo.existsById(dto.getPaymentId())) {
            repo.save(mapper.map(dto, Payment.class));
        } else {
            throw new RuntimeException("Payment Already Exist..!");
        }
    }

    @Override
    public void deletePayment(String pid) {
        if (repo.existsById(pid)) {
            repo.deleteById(pid);
        } else {
            throw new RuntimeException("Please Check the Payment ID.. No Such Payment..!");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {
        if (repo.existsById(dto.getPaymentId())) {
            repo.save(mapper.map(dto, Payment.class));
        } else {
            throw new RuntimeException("No Such Payment To Update..! Please Check the ID..!");
        }
    }

    @Override
    public PaymentDTO searchPayment(String pid) {
        if (repo.existsById(pid)) {
            return mapper.map(repo.findById(pid).get(), PaymentDTO.class);
        } else {
            throw new RuntimeException("No Car For " + pid + " ..!");
        }
    }

    @Override
    public List<PaymentDTO> getAllPayment() {
        return mapper.map(repo.findAll(), new TypeToken<List<PaymentDTO>>() {
        }.getType());
    }
}
