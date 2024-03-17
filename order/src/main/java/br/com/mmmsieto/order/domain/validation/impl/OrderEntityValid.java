package br.com.mmmsieto.order.domain.validation.impl;

import br.com.mmmsieto.order.domain.entity.OrderEntity;
import br.com.mmmsieto.order.domain.exceptions.DomainException;
import br.com.mmmsieto.order.domain.exceptions.Error;
import br.com.mmmsieto.order.domain.validation.Valid;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderEntityValid implements Valid {
    @Override
    public void execute(OrderEntity orderEntity) {
        List<Error> errors = new ArrayList<>();

        try {
            Validate.notNull(orderEntity.getId(), "id cannot be null");
        } catch (Exception e) {
            errors.add(new Error("id", "UUID","id is required" ,e.getMessage()));
        }

        try {
            Validate.notNull(orderEntity.getCustomerId(), "customerId cannot be null");
        } catch (Exception e) {
            errors.add(new Error("customerId", "UUID","customerId is required" ,e.getMessage()));
        }

        try {
            Validate.notNull(orderEntity.getProductId(), "productId cannot be null");
        } catch (Exception e) {
            errors.add(new Error("productId", "UUID","productId is required" ,e.getMessage()));
        }

        try {
            Validate.notNull(orderEntity.getQuantity(), "quantity cannot be null");
            Validate.isTrue(orderEntity.getQuantity() > 0, "quantity must be greater than zero");
        } catch (Exception e) {
            errors.add(new Error("quantity", "Integer","quantity is required" ,e.getMessage()));
        }

        try {
            Validate.notNull(orderEntity.getAmount(), "amount cannot be null");
            Validate.isTrue(orderEntity.getAmount().compareTo(BigDecimal.ZERO) > 0, "amount must be greater than zero");
        } catch (Exception e) {
            errors.add(new Error("amount", "BigDecimal","amount is required" ,e.getMessage()));
        }

        try {
            Validate.notNull(orderEntity.getDate(), "date cannot be null");
            Validate.isTrue(orderEntity.getDate().isAfter(LocalDateTime.now()), "date cannot be in the past");
        } catch (Exception e) {
            errors.add(new Error("date", "LocalDateTime","date is required" ,e.getMessage()));
        }

        if (!errors.isEmpty()) {
            throw DomainException.with("Error na validação na Order",errors);
        }
    }
}
