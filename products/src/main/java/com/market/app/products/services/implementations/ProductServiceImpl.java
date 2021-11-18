package com.market.app.products.services.implementations;

import com.market.app.products.dto.GeneralResponseDTO;
import com.market.app.products.entity.Product;
import com.market.app.products.repository.IProductRepository;
import com.market.app.products.services.interfaces.IProductService;
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
    public Product create(Product producto){
        return productRepository.save(producto);
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
