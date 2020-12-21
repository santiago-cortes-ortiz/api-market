package com.jeiss.market.persistence;

import com.jeiss.market.domain.Purchase;
import com.jeiss.market.domain.repository.PurchaseRespository;
import com.jeiss.market.persistence.crud.ComprasCrudRepository;
import com.jeiss.market.persistence.entity.Compra;
import com.jeiss.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRespository implements PurchaseRespository {

    @Autowired
    private ComprasCrudRepository comprasCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) comprasCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String idCliente) {
        return comprasCrudRepository.findByIdCliente(idCliente).
                map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {

        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(productos -> productos.setCompra(compra));
        return mapper.toPurchase(comprasCrudRepository.save(compra));

    }
}
