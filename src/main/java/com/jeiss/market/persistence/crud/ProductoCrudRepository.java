package com.jeiss.market.persistence.crud;

import com.jeiss.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<Producto> findByCatidadProductoLessThanAndEstado(int catidadProducto,boolean estado);
    Optional<List<Producto>> findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(int precioVenta, int idCategoria);
}
