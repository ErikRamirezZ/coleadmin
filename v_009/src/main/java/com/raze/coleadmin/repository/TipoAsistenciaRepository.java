package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.TipoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAsistenciaRepository extends JpaSpecificationExecutor<TipoAsistencia>, JpaRepository<TipoAsistencia, Long> {
}
