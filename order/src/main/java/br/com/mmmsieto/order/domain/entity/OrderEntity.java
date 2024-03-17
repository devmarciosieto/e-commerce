package br.com.mmmsieto.order.domain.entity;

import br.com.mmmsieto.order.domain.validation.Valid;
import br.com.mmmsieto.order.domain.validation.impl.OrderEntityValid;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class OrderEntity {

    private final UUID id;
    private final UUID customerId;
    private final UUID productId;
    private final Integer quantity;
    private final BigDecimal amount;
    private final LocalDateTime date;

    private OrderEntity(
            UUID id,
            UUID customerId,
            UUID productId,
            Integer quantity,
            BigDecimal amount,
            LocalDateTime date) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
        this.date = date;
    }

    public static class Builder {

        private final Valid validator = new OrderEntityValid();

        private UUID id;
        private UUID customerId;
        private UUID productId;
        private Integer quantity;
        private BigDecimal amount;
        private LocalDateTime date;

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder customerId(UUID customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder productId(UUID productId) {
            this.productId = productId;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public OrderEntity build() {
            OrderEntity orderEntity = new OrderEntity(id, customerId, productId, quantity, amount, date);
            validator.execute(orderEntity);
            return orderEntity;
        }
    }
}
