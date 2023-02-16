package com.example.bookmarts.service;



import  com.example.bookmarts.entity.Payment;

import java.util.List;

public interface PaymentService {
    void save(Payment payment);

    List<Payment> findAll();

    void deleteById(Integer id);
}
