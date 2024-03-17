package com.hakathon.controller;

import com.hakathon.entity.Payments;
import com.hakathon.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @GetMapping("/getAllPayments")
    public ResponseEntity<List<Payments>> getAllPayments() {
        List<Payments> payments = paymentsService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/getPaymentById/{paymentId}")
    public ResponseEntity<Payments> getPaymentById(@PathVariable Long paymentId) {
        Payments payment = paymentsService.getPaymentById(paymentId);
        if (payment != null) {
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/savePayment")
    public ResponseEntity<Payments> savePayment(@RequestBody Payments payment) {
        Payments savedPayment = paymentsService.savePayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePayment/{paymentId}")
    public ResponseEntity<String> deletePayment(@PathVariable Long paymentId) {
        paymentsService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
    }
}
