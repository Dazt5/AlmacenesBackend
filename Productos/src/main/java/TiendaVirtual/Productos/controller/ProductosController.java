// file: ProductosController

package TiendaVirtual.Productos.controller;

// ------------------------------------------------------

import TiendaVirtual.Productos.entity.Productos;
import TiendaVirtual.Productos.model.Response;
import TiendaVirtual.Productos.services.ProductosService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;
import java.math.BigInteger;


@RestController
@RequestMapping("/productos")
public class ProductosController { // class start
    // program start
    
    @Autowired
    private ProductosService productosService;
    
    @GetMapping("/")
    public List<Productos> getAllProductos(){
        return productosService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Productos> getProductoById(@PathVariable BigInteger id){
        return productosService.getById(id);
    }
    
    @PostMapping("/")
    public ResponseEntity<Response> createProducto(@RequestBody Productos producto){
        productosService.create(producto);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Producto agregado con exito [" + producto.getNombre_producto() + "]."));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateProductoById(@PathVariable BigInteger id, @RequestBody Productos producto){
        productosService.update(producto, id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Producto actualizado con exito [" + id + "]"));        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProductoById(@PathVariable BigInteger id){
        productosService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Producto elimiando con exito [" + id + "]"));     
    }

    
} // End of class 
