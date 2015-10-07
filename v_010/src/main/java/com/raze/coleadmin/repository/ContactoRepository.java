package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Contacto.class)
public interface ContactoRepository extends JpaSpecificationExecutor<Contacto>, JpaRepository<Contacto, Long> {
}
