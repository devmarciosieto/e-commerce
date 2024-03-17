package br.com.mmmsieto.order.domain.service;

import br.com.mmmsieto.order.app.v1.controller.dtos.ClientAddressEntity;
import br.com.mmmsieto.order.app.v1.controller.dtos.ClientEntity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ClientService {
    List<ClientEntity> list();

    List<ClientAddressEntity> listClient();

    List<ClientAddressEntity> listWithCompletableFuture();

    default CompletableFuture<ClientAddressEntity> getCompletableFuture(ClientEntity clientEntity) {
        ClientAddressEntity clientAddressEntity = getClientAddress(clientEntity);
        return CompletableFuture.completedFuture(clientAddressEntity);
    }

    ClientAddressEntity getClientAddress(ClientEntity clientEntity);
}
