// file: Response

package TiendaVirtual.Productos.model;

// ------------------------------------------------------

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@AllArgsConstructor
public class Response { // class start
    // program start
    
    private String message;

    public Response(String message) {
        this.message = message;
    }
    
} // End of class 
