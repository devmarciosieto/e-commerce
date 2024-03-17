package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.app.v1.controller.dtos.OrderResponse;
import br.com.mmmsieto.order.domain.service.*;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService {

    private final AddressService addressService;
    private final CarrierService carrierService;
    private final DeliveryService deliveryService;
    private final PaymentService paymentService;
    private final RestrictionService restrictionService;
    private final CustomerService customerService;
    private final StockService stockService;
    private final ValidationService validationService;
    private final FraudService fraudService;

    public OrderServiceImpl(AddressService addressService,
                            CarrierService carrierService,
                            DeliveryService deliveryService,
                            PaymentService paymentService,
                            RestrictionService restrictionService,
                            CustomerService customerService,
                            StockService stockService,
                            ValidationService validationService,
                            FraudService fraudService) {
        this.addressService = addressService;
        this.carrierService = carrierService;
        this.deliveryService = deliveryService;
        this.paymentService = paymentService;
        this.restrictionService = restrictionService;
        this.customerService = customerService;
        this.stockService = stockService;
        this.validationService = validationService;
        this.fraudService = fraudService;
    }

    @Override
    public OrderResponse createOrder() {

        String customer = customerService.customerSearch();

        OrderResponse orderResponse = new OrderResponse.Builder()
                .customer(customer)
                .address(addressService.checkAddress(customer))
                .carrier(carrierService.checkCarrier(customer))
                .delivery(deliveryService.checkDeliveryTime(customer))
                .payment(paymentService.checkPayment(customer))
                .restriction(restrictionService.checkRestriction(customer))
                .stock(stockService.checkStock(customer))
                .fraud(fraudService.checksForFraud(customer))
                .validation(validationService.checkValidacao(customer))
                .build();

        return orderResponse;
    }
}
