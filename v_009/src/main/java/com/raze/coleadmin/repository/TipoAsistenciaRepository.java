package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.TipoAsistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = TipoAsistencia.class)
public interface TipoAsistenciaRepository extends JpaSpecificationExecutor<TipoAsistencia>, JpaRepository<TipoAsistencia, Long> {
}
