package net.outsila.ebankservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import net.outsila.ebankservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="customerService" , fallbackMethod = "getDefaultCusomter")
    Customer getCustomerById(@PathVariable Long id);

    default Customer getDefaultCustomer(Exception e , Long id){
        return new Customer(id,"Not Found","Not Found");
    }
}
