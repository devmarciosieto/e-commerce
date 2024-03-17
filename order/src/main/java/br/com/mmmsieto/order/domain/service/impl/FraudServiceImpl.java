package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.FraudService;
import org.springframework.stereotype.Service;

@Service
public class FraudServiceImpl implements FraudService {

    @Override
    public String checksForFraud(String customer) {
        try {
            Thread.sleep(480);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return String.format("%s no fraud", customer);
    }

}