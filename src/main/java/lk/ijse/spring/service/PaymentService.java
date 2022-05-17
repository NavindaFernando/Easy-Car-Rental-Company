package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    void savePayment(PaymentDTO dto);
    void deletePayment(String pid);
    void updatePayment(PaymentDTO dto);
    PaymentDTO searchPayment(String pid);
    List<PaymentDTO> getAllPayment();
}
