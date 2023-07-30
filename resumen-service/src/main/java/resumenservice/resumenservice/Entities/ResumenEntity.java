package resumenservice.resumenservice.Entities;

import javax.persistence.*;
import lombok.*;
import resumenservice.resumenservice.Models.Entrada;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "resumen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumenEntity {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    private Integer saldo;

    private String numDoc;
    //Entrada o Salida
    private String tipo;

    //Dinero total del giro
    private Integer monto;

    //Motivo del giro
    private String motivo;

    //Boleta o Factura
    private String tipoDoc;

    private Date fecha;


}