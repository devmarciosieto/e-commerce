package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.DeliveryService;
import org.springframework.stereotype.Service;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Override
    public String checkDeliveryTime(String customer) {
        try {
            Thread.sleep(220);
            return String.format("%s Delivery Time", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
