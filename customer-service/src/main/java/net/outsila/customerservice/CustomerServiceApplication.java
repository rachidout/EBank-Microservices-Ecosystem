package net.outsila.customerservice;

import net.outsila.customerservice.entities.Customer;
import net.outsila.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
          customerRepository.save(
                  Customer.builder().name("rachid").email("rachid@email.com").build()
          );
          customerRepository.save(
                  Customer.builder().name("fatima").email("fatima@gmail.com").build()
          );
          customerRepository.findAll().forEach(System.out::println);
        };

    }
}
