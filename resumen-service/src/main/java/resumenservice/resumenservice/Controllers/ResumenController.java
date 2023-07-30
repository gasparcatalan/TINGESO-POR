package resumenservice.resumenservice.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resumenservice.resumenservice.Entities.ResumenEntity;
import resumenservice.resumenservice.Services.ResumenService;

import java.util.Date;
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

    @PostMapping("/generar")
    public String generarResumenes(@RequestParam("fechaInicial") Date fechaInicial,
                                   @RequestParam("fechaFinal") Date fechaFinal) {
        try {
            resumenService.generarResumenes(fechaInicial, fechaFinal);
            return "Resumenes generados exitosamente";
        } catch (Exception e) {
            // Manejo de errores de acuerdo a tu necesidad
            return "Error al generar resumenes: " + e.getMessage();
        }
    }
}
