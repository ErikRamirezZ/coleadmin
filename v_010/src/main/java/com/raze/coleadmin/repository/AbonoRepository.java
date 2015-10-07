package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Abono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Abono.class)
public interface AbonoRepository extends JpaSpecificationExecutor<Abono>, JpaRepository<Abono, Long> {
}
