package entradaservice.entradaservice.Controllers;
import entradaservice.entradaservice.Entities.EntradaEntity;
import entradaservice.entradaservice.Models.CrearEntradaRequest;
import entradaservice.entradaservice.Services.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/entrada")
public class EntradaController {

    @Autowired
    EntradaService entradaService;

    @GetMapping
    public ResponseEntity<List<EntradaEntity>> getall(){
        List<EntradaEntity> e = entradaService.getAll();
        if (e.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(e);
    }


    @PostMapping("/crear")
    public ResponseEntity<String>  crearEntrada(@RequestBody CrearEntradaRequest r){
        entradaService.crearEntrada(r.getNumDoc(), r.getMonto(), r.getMotivo(),r.getTipoDoc(),r.getFecha());
        return ResponseEntity.ok("Entrada Generada Correctamente");
    }

}
