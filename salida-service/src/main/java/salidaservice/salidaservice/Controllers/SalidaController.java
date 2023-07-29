package salidaservice.salidaservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import salidaservice.salidaservice.Entities.SalidaEntity;
import salidaservice.salidaservice.Models.CrearSalidaRequest;
import salidaservice.salidaservice.Services.SalidaService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/salida")
public class SalidaController {

    @Autowired
    SalidaService salidaService;

    @GetMapping
    public ResponseEntity<List<SalidaEntity>> getall(){
        List<SalidaEntity> e = salidaService.getAll();
        if (e.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(e);
    }


    @PostMapping("/crear")
    public ResponseEntity<String>  crearEntrada(@RequestBody CrearSalidaRequest r){
        salidaService.crearEntrada(r.getNumDoc(), r.getMonto(), r.getMotivo(),r.getTipoDoc(),r.getFecha());
        return ResponseEntity.ok("Salida Generada Correctamente");
    }

}