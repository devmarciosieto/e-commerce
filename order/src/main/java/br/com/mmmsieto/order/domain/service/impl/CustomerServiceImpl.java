package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public String customerSearch() {
        try {
            Thread.sleep(410);
            return "customer Id: 1";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
