package  com.example.bookmarts.service.impl;

import com.example.bookmarts.entity.Payment;
import com.example.bookmarts.repository.PaymentRepository;
import com.example.bookmarts.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
//    private final PaymentService paymentService;


    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
//        this.paymentService = paymentService;
    }

    @Override
    public void save(Payment payment) {
        paymentRepository.save(payment);
    }

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void deleteById(Integer id){
        paymentRepository.deleteById(Long.valueOf(id));
    }

}
