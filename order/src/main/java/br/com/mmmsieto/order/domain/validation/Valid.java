package br.com.mmmsieto.order.domain.validation;

import br.com.mmmsieto.order.domain.entity.OrderEntity;

public interface Valid {
    void execute(OrderEntity orderEntity);
}
