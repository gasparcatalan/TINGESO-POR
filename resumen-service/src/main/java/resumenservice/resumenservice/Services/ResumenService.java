package resumenservice.resumenservice.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import resumenservice.resumenservice.Config.RestTemplateConfig;
import resumenservice.resumenservice.Entities.ResumenEntity;
import resumenservice.resumenservice.Models.Entrada;
import resumenservice.resumenservice.Models.Salida;
import resumenservice.resumenservice.Models.Transaccion;
import resumenservice.resumenservice.Repositories.ResumenRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ResumenService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ResumenRepository resumenRepository;

    public List<ResumenEntity> getall(){
        return (List<ResumenEntity>) resumenRepository.findAll();
    }

    public List<Entrada> obtenerEntradas(){
        ResponseEntity<List<Entrada>> response = restTemplate.exchange(
                "http://localhost:8080/entrada/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Entrada>>() {}
        );
        return response.getBody();
    }

    public List<Salida> obtenerSalidas(){
        ResponseEntity<List<Salida>> response = restTemplate.exchange(
                "http://localhost:8080/salida/",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Salida>>() {}
        );
        return response.getBody();
    }

    public void generarResumenes(Date inicial, Date fin) {
        List<Transaccion> transacciones = new ArrayList<>();

        // Obtener y filtrar entradas por fecha
        for (Entrada entrada : obtenerEntradas()) {
            if (!entrada.getFecha().before(inicial) && !entrada.getFecha().after(fin)) {
                transacciones.add(new Transaccion(
                        entrada.getNumDoc(),
                        "Entrada",
                        entrada.getMonto(),
                        entrada.getMotivo(),
                        entrada.getTipoDoc(),
                        entrada.getFecha()
                ));
            }
        }

        // Obtener y filtrar salidas por fecha
        for (Salida salida : obtenerSalidas()) {
            if (!salida.getFecha().before(inicial) && !salida.getFecha().after(fin)) {
                transacciones.add(new Transaccion(
                        salida.getNumDoc(),
                        "Salida",
                        -salida.getMonto(),
                        salida.getMotivo(),
                        salida.getTipoDoc(),
                        salida.getFecha()
                ));
            }
        }

        // Ordenar las transacciones por fecha
        transacciones.sort(Comparator.comparing(Transaccion::getFecha));
        int saldo = 0;
        // Procesar las transacciones y generar resúmenes
        for (Transaccion transaccion : transacciones) {
            saldo += transaccion.getMonto();

            ResumenEntity resumen = new ResumenEntity();
            resumen.setSaldo(saldo);
            resumen.setNumDoc(transaccion.getNumDoc());
            resumen.setTipo(transaccion.getTipo());
            resumen.setMonto(transaccion.getMonto());
            resumen.setMotivo(transaccion.getMotivo());
            resumen.setTipoDoc(transaccion.getTipoDoc());
            resumen.setFecha(transaccion.getFecha());

            resumenRepository.save(resumen);

        }
    }


}
