package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Inscrpcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Inscrpcion.class)
public interface InscrpcionRepository extends JpaRepository<Inscrpcion, Long>, JpaSpecificationExecutor<Inscrpcion> {
}
