package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String checkPayment(String customer) {
        try {
            Thread.sleep(420);
            return String.format("%s payment confirmed", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
