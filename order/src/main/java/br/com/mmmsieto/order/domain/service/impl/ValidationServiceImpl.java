package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    @Override
    public String checkValidacao(String customer) {
        try {
            Thread.sleep(100);
            return String.format("%s payment confirmed", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
