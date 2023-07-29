package salidaservice.salidaservice.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import salidaservice.salidaservice.Entities.SalidaEntity;

import java.util.Date;
import java.util.List;
@Repository
public interface SalidaRepository extends CrudRepository<SalidaEntity, Long> {


    @Query("SELECT s FROM SalidaEntity s ")
    List<SalidaEntity> getAll();
}
