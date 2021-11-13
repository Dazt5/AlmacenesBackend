// file: IProductosRepository

package TiendaVirtual.Productos.repository.interfaces;

import TiendaVirtual.Productos.entity.Productos;
import java.math.BigInteger;
import org.springframework.data.mongodb.repository.MongoRepository;


// ------------------------------------------------------

public interface IProductosRepository extends MongoRepository<Productos, BigInteger>{ // class start
    // program start    
    
} // End of class 
