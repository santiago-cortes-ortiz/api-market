package com.jeiss.market.persistence;

import com.jeiss.market.persistence.crud.ProductoCrudRepository;
import com.jeiss.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }
    public Optional<Producto> getEscasos(int cantidad){
        return productoCrudRepository.findByCatidadProductoLessThanAndEstado(cantidad,true);
    }
    public Optional<List<Producto>> getMenorPrecioVenta (int precioVenta, int idCategoria) {
        return productoCrudRepository.findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(precioVenta, idCategoria);
    }
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
