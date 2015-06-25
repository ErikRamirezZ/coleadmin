package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaSpecificationExecutor<Asistencia>, JpaRepository<Asistencia, Long> {
}
