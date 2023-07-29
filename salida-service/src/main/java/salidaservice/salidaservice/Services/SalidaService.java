package salidaservice.salidaservice.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salidaservice.salidaservice.Entities.SalidaEntity;
import salidaservice.salidaservice.Repositories.SalidaRepository;

import java.util.Date;
import java.util.List;

@Service
public class SalidaService {

    @Autowired
    SalidaRepository salidaRepository;

    public List<SalidaEntity> getAll(){

        return (List<SalidaEntity>) salidaRepository.findAll();
    }

    public void crearEntrada(String numDoc,Integer monto, String motivo, String tipoDoc, Date fecha ){
        SalidaEntity salida = new SalidaEntity();
        salida.setNumDoc(numDoc);
        salida.setMonto(monto);
        salida.setMotivo(motivo);
        salida.setTipoDoc(tipoDoc);
        salida.setFecha(fecha);
        salidaRepository.save(salida);
    }

}
