package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Domicilio.class)
public interface DomicilioRepository extends JpaRepository<Domicilio, Long>, JpaSpecificationExecutor<Domicilio> {
}
