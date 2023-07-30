package salidaservice.salidaservice.Entities;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "salida")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalidaEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    //numero de documento
    private String numDoc;
    //Entrada o Salida
    private String tipo= "Salida";

    //Dinero total del giro
    private Integer monto;

    //Motivo del giro
    private String motivo;

    //Boleta o Factura
    private String tipoDoc;

    private Date fecha;


}