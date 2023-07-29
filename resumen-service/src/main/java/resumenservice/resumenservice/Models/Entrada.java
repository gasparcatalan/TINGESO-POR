package resumenservice.resumenservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Entrada {

    private String numDoc;
    //Entrada o Salida
    private String tipo= "Entrada";

    //Dinero total del giro
    private Integer monto;

    //Motivo del giro
    private String motivo;

    //Boleta o Factura
    private String tipoDoc;

    private Date fecha;
}
