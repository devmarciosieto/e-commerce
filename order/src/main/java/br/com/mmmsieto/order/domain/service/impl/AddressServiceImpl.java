package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.AddressService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Override
    public String checkAddress(String customer) {
        try {
            Thread.sleep(330);
            return String.format("%s address", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
