package entradaservice.entradaservice.Repositories;

import entradaservice.entradaservice.Entities.EntradaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface EntradaRepository extends CrudRepository<EntradaEntity, Long> {

    @Query("SELECT e FROM EntradaEntity e ")
    List<EntradaEntity> getAll();
}
