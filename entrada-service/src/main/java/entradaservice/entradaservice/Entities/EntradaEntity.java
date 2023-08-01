package entradaservice.entradaservice.Entities;

import javax.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "entrada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Num Doc
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
