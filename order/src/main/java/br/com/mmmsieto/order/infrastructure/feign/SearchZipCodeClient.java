package br.com.mmmsieto.order.infrastructure.feign;

import br.com.mmmsieto.order.app.v1.controller.dtos.AddressEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "zipCode", url = "${feign.client.zipCode.url}")
public interface SearchZipCodeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{zipCode}/json")
    AddressEntity buscaCep(@PathVariable("zipCode") String zipCode);

}
