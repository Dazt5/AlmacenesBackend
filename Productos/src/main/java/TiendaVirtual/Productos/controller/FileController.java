// file: FileController

package TiendaVirtual.Productos.controller;

// ------------------------------------------------------

import TiendaVirtual.Productos.model.Response;
import TiendaVirtual.Productos.repository.interfaces.IFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/files")
public class FileController { // class start
    // program start
    
    @Autowired
    private IFileRepository fileService;
    
    @PostMapping("/upload")
    public ResponseEntity<Response> uploadFiles(@RequestParam("files") List<MultipartFile> files) throws Exception{
        fileService.save(files);
        return ResponseEntity.status(HttpStatus.OK).body(new Response("Los archivos fueron cargados correctamente al servidor"));
    }
    
} // End of class 
