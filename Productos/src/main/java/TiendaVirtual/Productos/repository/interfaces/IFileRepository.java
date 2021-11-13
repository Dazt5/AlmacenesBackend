// file: IFileRepository

package TiendaVirtual.Productos.repository.interfaces;

// ------------------------------------------------------


import TiendaVirtual.Productos.model.Response;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;


import java.util.List;


public interface IFileRepository { // class start
    // program start
    
    public void save(MultipartFile file) throws Exception;
    public void  save(List<MultipartFile> files) throws Exception;
    
    public ResponseEntity<Response> datos_db(MultipartFile file) throws Exception;    
    
} // End of class 
