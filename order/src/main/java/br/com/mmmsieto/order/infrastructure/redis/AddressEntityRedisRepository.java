package br.com.mmmsieto.order.infrastructure.redis;

import br.com.mmmsieto.order.app.v1.controller.dtos.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressEntityRedisRepository extends CrudRepository<AddressEntity, String> {
}
