package com.amaris.repository;

import com.amaris.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    @Query( value = "select p from PersonaEntity p where p.tipoDocumento = :tipoDocumento and p.numDocumento = :numDocumento")
    PersonaEntity findByTipoDocumentoAndNumDocumento(@Param("tipoDocumento")String tipoDocumento,
                                                               @Param("numDocumento") Integer numDocumento);

}
