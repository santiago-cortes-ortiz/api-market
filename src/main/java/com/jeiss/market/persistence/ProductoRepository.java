package com.jeiss.market.persistence;

import com.jeiss.market.domain.Product;
import com.jeiss.market.domain.repository.ProductRepository;
import com.jeiss.market.persistence.crud.ProductoCrudRepository;
import com.jeiss.market.persistence.entity.Producto;
import com.jeiss.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    private ProductoCrudRepository productoCrudRepository;
    private ProductMapper productMapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return productMapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(productMapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCatidadProductoLessThanAndEstado(quantity,true);
        return productos.map(prds -> productMapper.toProducts(prds));
    }

    @Override
    public Optional<List<Product>> getLowerPriceSale(int priceSale, int categoryId) {
        Optional<List<Producto>> productos = productoCrudRepository.findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(priceSale, categoryId);
        return productos.map(prds -> productMapper.toProducts(prds));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        Optional<Producto> producto = productoCrudRepository.findById(productId);
        return producto.map(prd -> productMapper.toProduct(prd));
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(productoCrudRepository.save(productMapper.toProducto(product)));
    }

    @Override
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
