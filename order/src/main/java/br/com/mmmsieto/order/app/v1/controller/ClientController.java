package br.com.mmmsieto.order.app.v1.controller;

import br.com.mmmsieto.order.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/clients")
@RestController
public class ClientController {

    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<?> index() {
        log.info("List");
        return ResponseEntity.ok(clientService.listClient());
    }

    @GetMapping("/threads")
    public ResponseEntity<?> indexThreads() {
        log.info("List with threads");
        return ResponseEntity.ok(clientService.listWithCompletableFuture());
    }

}
