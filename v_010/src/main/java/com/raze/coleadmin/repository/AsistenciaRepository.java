package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Asistencia.class)
public interface AsistenciaRepository extends JpaSpecificationExecutor<Asistencia>, JpaRepository<Asistencia, Long> {
}
