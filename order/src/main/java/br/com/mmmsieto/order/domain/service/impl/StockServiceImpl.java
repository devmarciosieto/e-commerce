package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.StockService;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl  implements StockService {

    @Override
    public String checkStock(String customer) {
        try {
            Thread.sleep(390);
            return String.format("%s stock confirmed", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
