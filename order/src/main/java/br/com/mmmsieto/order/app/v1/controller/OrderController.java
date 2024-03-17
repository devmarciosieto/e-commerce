package br.com.mmmsieto.order.app.v1.controller;

import br.com.mmmsieto.order.domain.service.OrderService;
import br.com.mmmsieto.order.domain.service.OrderThreadsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderThreadsService orderThreadsService;

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping
    public ResponseEntity<?> index() {
        log.info("create new order");

        return ResponseEntity.ok(orderService.createOrder());
    }

    @GetMapping("/threads")
    public ResponseEntity<?> indexThreads() {
        log.info("create new order with threads");

        return ResponseEntity.ok(orderThreadsService.createOrder());
    }



}
