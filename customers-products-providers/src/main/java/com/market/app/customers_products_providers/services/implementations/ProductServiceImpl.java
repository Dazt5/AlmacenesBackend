package com.market.app.customers_products_providers.services.implementations;

import com.market.app.customers_products_providers.dto.ProductRequestDTO;
import com.market.app.customers_products_providers.dto.GeneralResponseDTO;
import com.market.app.customers_products_providers.entity.Product;
import com.market.app.customers_products_providers.repository.IProductRepository;
import com.market.app.customers_products_providers.services.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{
    
    @Autowired
    private IProductRepository productRepository;
    
    GeneralResponseDTO responseDTO;
    
    @Override
    public ArrayList<Product> getAll(){
        return (ArrayList<Product>) productRepository.findAll();
    }
    
    @Override
    public Optional<Product> getById(BigInteger id){
        return productRepository.findById(id);
    }
    
    @Override
    public Product create(ProductRequestDTO producto){
        return productRepository.save(producto.toEntity());
    }
    
    @Override
    public Product update(Product producto, BigInteger id){
        Product actualProducto = productRepository.findById(id).orElse(null);
        
        if(actualProducto == null) return null;
        
        actualProducto.setNombre_producto(producto.getNombre_producto());
        actualProducto.setNitproveedor(producto.getNitproveedor());
        actualProducto.setPrecio_compra(producto.getPrecio_compra());
        actualProducto.setIvacompra(producto.getIvacompra());
        actualProducto.setPrecio_venta(producto.getPrecio_venta());
        
        return productRepository.save(actualProducto);
    }
    
    @Override
    public void delete(BigInteger id){
        productRepository.deleteById(id);
    }
    
} 
