package net.outsila.ebankservice;

import net.outsila.ebankservice.entities.BankAccount;
import net.outsila.ebankservice.services.EbankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients

public class EbankServiceApplication {

    private final EbankService ebankService;

    // Constructor injection for your service
    public EbankServiceApplication(EbankService ebankService) {
        this.ebankService = ebankService;
    }

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    // Fixed: Added @Bean so Spring executes this at startup
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 1; i <= 2; i++) {
                // Fixed: Condition changed to j < 5 to avoid infinite loop
                for (int j = 0; j < 5; j++) {
                    // Fixed: Using the correct static Lombok builder syntax
                    ebankService.save(BankAccount.builder()
                            .type(Math.random() > 0.5 ? "CURRENT_ACCOUNT" : "SAVING_ACCOUNT")
                            .balance(1000 + Math.random() * 60000)
                            .customerId((long) i)
                            .build());
                }
            }
        };
    }
}
