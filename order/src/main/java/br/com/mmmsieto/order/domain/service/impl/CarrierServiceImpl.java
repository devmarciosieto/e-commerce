package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.CarrierService;
import org.springframework.stereotype.Service;

@Service
public class CarrierServiceImpl implements CarrierService {

    @Override
    public String checkCarrier(String customer) {
        try {
            Thread.sleep(285);
            return String.format("%s carrier", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
