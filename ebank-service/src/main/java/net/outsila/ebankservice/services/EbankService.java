package net.outsila.ebankservice.services;

import net.outsila.ebankservice.entities.BankAccount;
import net.outsila.ebankservice.feign.CustomerRestClient;
import net.outsila.ebankservice.model.Customer;
import net.outsila.ebankservice.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {

    private final  BankAccountRepository accountRepository;
    private final CustomerRestClient customerRestClient;

    public EbankService(BankAccountRepository accountRepository ,CustomerRestClient customerRestClient ){
        this.customerRestClient = customerRestClient;
        this.accountRepository = accountRepository;
    }
    public List<BankAccount> getAllBankAccounts(){
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountByID(String id){
       BankAccount bankAccount = accountRepository.findById(id).orElseThrow(() ->new RuntimeException("No Account was found"));
       bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
       return bankAccount;
    }

    public BankAccount save(BankAccount bankAccount){
        try{
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return accountRepository.save(bankAccount);
        }catch(Exception e){
            throw new RuntimeException("here");
        }
    }

    public List<BankAccount> findByCustomerId(Long id) {
        return accountRepository.findByCustomerId(id);
    }

}
