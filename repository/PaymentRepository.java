package com.example.audible.repository;
import com.example.audible.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}