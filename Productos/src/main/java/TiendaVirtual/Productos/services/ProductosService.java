// file: ProductosService

package TiendaVirtual.Productos.services;

// ------------------------------------------------------

import TiendaVirtual.Productos.entity.Productos;
import TiendaVirtual.Productos.repository.interfaces.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductosService { // class start
    // program start
    
    @Autowired
    private IProductosRepository productosRepository;
    
    public ArrayList<Productos> getAll(){
        return (ArrayList<Productos>) productosRepository.findAll();
    }
    
    public Optional<Productos> getById(BigInteger id){
        return productosRepository.findById(id);
    }
    
    public Productos create(Productos producto){
        return productosRepository.save(producto);
    }
    
    public Productos update(Productos producto, BigInteger id){
        Productos actualProducto = productosRepository.findById(id).orElse(null);
        System.out.println(actualProducto.toString());
        
        if(actualProducto == null) return null;
        
        actualProducto.setIva_compra(producto.getIva_compra());
        actualProducto.setNit_proveedor(producto.getNit_proveedor());
        actualProducto.setNombre_producto(producto.getNombre_producto());
        actualProducto.setPrecio_compra(producto.getPrecio_compra());
        actualProducto.setPrecio_venta(producto.getPrecio_venta());
        
        return productosRepository.save(actualProducto);        
    }
    
    public void delete(BigInteger id){
        productosRepository.deleteById(id);
    }
    
} // End of class 
