package br.com.mmmsieto.order.domain.service.impl;

import br.com.mmmsieto.order.app.v1.controller.dtos.OrderResponse;
import br.com.mmmsieto.order.domain.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class OrderThreadsServiceImpl implements OrderThreadsService {

    private final TaskExecutor taskExecutor;
    private final AddressService addressService;
    private final CarrierService carrierService;
    private final DeliveryService deliveryService;
    private final PaymentService paymentService;
    private final RestrictionService restrictionService;
    private final CustomerService customerService;
    private final StockService stockService;
    private final ValidationService validationService;
    private final FraudService fraudService;

    public OrderThreadsServiceImpl(@Qualifier("applicationTaskExecutor") TaskExecutor taskExecutor,
                                    AddressService addressService,
                                    CarrierService carrierService,
                                    DeliveryService deliveryService,
                                    PaymentService paymentService,
                                    RestrictionService restrictionService,
                                    CustomerService customerService,
                                    StockService stockService,
                                    ValidationService validationService,
                                    FraudService fraudService) {
        this.taskExecutor = taskExecutor;
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

        CompletableFuture<String> addressServiceFuture = CompletableFuture.supplyAsync(() -> addressService.checkAddress(customer), taskExecutor);
        CompletableFuture<String> carrierServiceFuture = CompletableFuture.supplyAsync(() -> carrierService.checkCarrier(customer), taskExecutor);
        CompletableFuture<String> deliveryServiceFuture = CompletableFuture.supplyAsync(() -> deliveryService.checkDeliveryTime(customer), taskExecutor);
        CompletableFuture<String> paymentServiceFuture = CompletableFuture.supplyAsync(() -> paymentService.checkPayment(customer), taskExecutor);
        CompletableFuture<String> restrictionServiceFuture = CompletableFuture.supplyAsync(() -> restrictionService.checkRestriction(customer), taskExecutor);
        CompletableFuture<String> stockServiceFuture = CompletableFuture.supplyAsync(() -> stockService.checkStock(customer), taskExecutor);
        CompletableFuture<String> validationServiceFuture = CompletableFuture.supplyAsync(() -> validationService.checkValidacao(customer), taskExecutor);
        CompletableFuture<String> fraudServiceFuture = CompletableFuture.supplyAsync(() -> fraudService.checksForFraud(customer), taskExecutor);

        CompletableFuture<Void> allFuture = CompletableFuture.allOf(
                addressServiceFuture,
                carrierServiceFuture,
                deliveryServiceFuture,
                paymentServiceFuture,
                restrictionServiceFuture,
                stockServiceFuture,
                validationServiceFuture,
                fraudServiceFuture);

        try {
            allFuture.get();

            return new OrderResponse.Builder()
                    .customer(customer)
                    .address(addressServiceFuture.get(3, TimeUnit.SECONDS))
                    .carrier(carrierServiceFuture.get(3, TimeUnit.SECONDS))
                    .delivery(deliveryServiceFuture.get(3, TimeUnit.SECONDS))
                    .payment(paymentServiceFuture.get(3, TimeUnit.SECONDS))
                    .restriction(restrictionServiceFuture.get(3, TimeUnit.SECONDS))
                    .stock(stockServiceFuture.get(3, TimeUnit.SECONDS))
                    .validation(validationServiceFuture.get(3, TimeUnit.SECONDS))
                    .fraud(fraudServiceFuture.get(3, TimeUnit.SECONDS))
                    .build();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }
}
