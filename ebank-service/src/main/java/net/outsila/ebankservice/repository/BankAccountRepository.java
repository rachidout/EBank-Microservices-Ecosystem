package net.outsila.ebankservice.repository;

import net.outsila.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
   List<BankAccount> findByCustomerId(Long id);
}
