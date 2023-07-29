package resumenservice.resumenservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import resumenservice.resumenservice.Entities.ResumenEntity;
import resumenservice.resumenservice.Services.ResumenService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/resumen")

public class ResumenController {

    @Autowired
    ResumenService resumenService;

    @GetMapping
    public ResponseEntity<List<ResumenEntity>> getall(){
        List<ResumenEntity> r = resumenService.getall();
        if (r.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(r);
    }
}
