package entradaservice.entradaservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrearEntradaRequest {
    private String numDoc;
    private Integer monto;
    private String motivo;
    private String tipoDoc;
    private Date fecha;
}
