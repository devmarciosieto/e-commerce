package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.domain.service.RestrictionService;
import org.springframework.stereotype.Service;

@Service
public class RestrictionServiceImpl implements RestrictionService {

    @Override
    public String checkRestriction(String customer) {
        try {
            Thread.sleep(150);
            return String.format("%s no restriction", customer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
