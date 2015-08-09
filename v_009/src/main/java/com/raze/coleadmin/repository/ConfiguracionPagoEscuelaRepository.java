package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.ConfiguracionPagoEscuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = ConfiguracionPagoEscuela.class)
public interface ConfiguracionPagoEscuelaRepository extends JpaRepository<ConfiguracionPagoEscuela, Long>, JpaSpecificationExecutor<ConfiguracionPagoEscuela> {
}
