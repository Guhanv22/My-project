package com.example.audible.Service;
import com.example.audible.model.Audiocast;
import com.example.audible.model.Payment;
import com.example.audible.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getAllpayment() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(int id) {
        return paymentRepository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment savePaymentDetails(Payment payment) {

        return paymentRepository.save(payment);
    }
}