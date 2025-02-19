package com.example.audible.controller;

import com.example.audible.Service.PaymentService;
import com.example.audible.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllpayment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/addPaymentDetails")
    public Payment postPaymentDetails(@RequestBody Payment payment){
        return paymentService.savePaymentDetails(payment);
    }
}
