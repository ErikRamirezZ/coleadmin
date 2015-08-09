package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Pago.class)
public interface PagoRepository extends JpaSpecificationExecutor<Pago>, JpaRepository<Pago, Long> {
}
