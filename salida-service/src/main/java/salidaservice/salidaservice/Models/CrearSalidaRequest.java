package salidaservice.salidaservice.Models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CrearSalidaRequest {
    private String numDoc;
    private Integer monto;
    private String motivo;
    private String tipoDoc;
    private Date fecha;
}