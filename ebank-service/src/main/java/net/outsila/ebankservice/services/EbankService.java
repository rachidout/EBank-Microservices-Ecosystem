package net.outsila.ebankservice.services;

import net.outsila.ebankservice.entities.BankAccount;
import net.outsila.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    @Autowired
    private BankAccountRepository accountRepository;

    public List<BankAccount> getAllBankAccounts(){
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountByID(String id){
        return accountRepository.findById(id).orElseThrow(() ->new RuntimeException("No Account was found"));
    }

    public BankAccount save(BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return accountRepository.save(bankAccount);
    }

}
