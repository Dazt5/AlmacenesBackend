// file: FileService

package TiendaVirtual.Productos.services;

// ------------------------------------------------------


import TiendaVirtual.Productos.entity.Productos;
import TiendaVirtual.Productos.model.Response;
import TiendaVirtual.Productos.repository.interfaces.IFileRepository;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@Service
public class FileService implements IFileRepository{ // class start    
    // program start
    
    private final Path rootFolder = Paths.get("uploads");
    
    @Autowired
    ProductosService productosService;
    
    @Override
    public void save(MultipartFile file) throws Exception {
        Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename())); // enviando el archivo a la carpeta.
        datos_db(file);
    }

    @Override
    public void save(List<MultipartFile> files) throws Exception {        
        for(MultipartFile file : files){ // recorriendo la lista de archivos que a su vez se guardan en la carpeta con la llamada al metodo 'save'
            this.save(file);            
        }       
    }
    
    
    @Override
    public ResponseEntity<Response> datos_db(MultipartFile file) throws Exception {
        
        System.out.println("ejecutando esta seccion");        
        List<Productos> productos = new ArrayList<>();        
                                  
        try(Stream<String> streamFile = Files.lines(rootFolder.resolve(file.getOriginalFilename()))){ // leer directamente el archivo y almacenarlo en esta estructura
            
            streamFile.map(linea -> linea.split(",")).map(arreglo -> { 
                
                BigInteger codigo_producto = new BigInteger(arreglo[0]);     
                Double iva_compra = Double.parseDouble(arreglo[1]);
                BigInteger nit_proveedor = new BigInteger(arreglo[2]);
                String nombre_producto = arreglo[3];
                Double precio_compra = Double.parseDouble(arreglo[4]);
                Double precio_venta = Double.parseDouble(arreglo[5]);
                
                Productos producto = new Productos(codigo_producto, iva_compra, nit_proveedor, nombre_producto, precio_compra, precio_venta);                
                                
                productosService.create(producto);
                               
                return producto;                
            }).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(new Response("Los archivos se guardaron correctamente en el servidor y la base de datos"));    
        } catch(IOException io){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Response("No se obtuvieron los datos correctamente, error: " + io));
        }        
    }
          
} // End of class 
