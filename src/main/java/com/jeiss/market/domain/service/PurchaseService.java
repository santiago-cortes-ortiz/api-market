package com.jeiss.market.domain.service;

import com.jeiss.market.domain.Purchase;
import com.jeiss.market.persistence.CompraRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private CompraRespository compraRespository;

    public List<Purchase> getAll(){
        return compraRespository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return compraRespository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase){
        return compraRespository.save(purchase);
    }

}
