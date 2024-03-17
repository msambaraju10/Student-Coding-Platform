package com.hakathon.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakathon.entity.Payments;
import com.hakathon.repository.PaymentsRepository;
import com.hakathon.service.PaymentsService;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    private final PaymentsRepository paymentsRepository;

    @Autowired
    public PaymentsServiceImpl(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Override
    public List<Payments> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public Payments getPaymentById(Long paymentId) {
        Optional<Payments> optionalPayment = paymentsRepository.findById(paymentId);
        return optionalPayment.orElse(null);
    }

    @Override
    public Payments savePayment(Payments payment) {
        return paymentsRepository.save(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentsRepository.deleteById(paymentId);
    }
    
    @Override
    public List<Payments> getPaymentsByRegistrationId(Long registrationId) {
        return paymentsRepository.findByContestRegistrations_RegistrationId(registrationId);
    }
}

