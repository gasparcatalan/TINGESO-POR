package entradaservice.entradaservice.Services;


import entradaservice.entradaservice.Entities.EntradaEntity;
import entradaservice.entradaservice.Repositories.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EntradaService {

    @Autowired
    EntradaRepository entradaRepository;

    public List<EntradaEntity> getAll(){

        return (List<EntradaEntity>) entradaRepository.findAll();
    }

    public void crearEntrada(String numDoc,Integer monto, String motivo, String tipoDoc, Date fecha ){
        EntradaEntity entrada = new EntradaEntity();
        entrada.setNumDoc(numDoc);
        entrada.setMonto(monto);
        entrada.setMotivo(motivo);
        entrada.setTipoDoc(tipoDoc);
        entrada.setFecha(fecha);
        entradaRepository.save(entrada);
    }

}
