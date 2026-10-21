package net.outsila.ebankservice.controllers;

import net.outsila.ebankservice.entities.BankAccount;
import net.outsila.ebankservice.services.EbankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EbankRestController {
    @Autowired
    private EbankService Ebankservice;

    @GetMapping("/accounts")
    public List<BankAccount> getAllBankAccounts(){
        return Ebankservice.getAllBankAccounts();
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountByID(@PathVariable String id){
        return Ebankservice.getBankAccountByID(id);
    }

    @PostMapping("/accounts")
    public BankAccount save(BankAccount bankAccount){
        return Ebankservice.save(bankAccount);
    }


}
