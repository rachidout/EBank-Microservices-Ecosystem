package net.outsila.ebankservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import net.outsila.ebankservice.model.Customer;

import java.util.Date;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccount {
    @Id
    private String id;
    private Date CreatedAt;
    private double balance;
    private String type;

    private Long customerId;

    //  The temporary object held in memory, ignored by the database
    @Transient
    private Customer customer;

}
