package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Correo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Correo.class)
public interface CorreoRepository extends JpaSpecificationExecutor<Correo>, JpaRepository<Correo, Long> {
}
