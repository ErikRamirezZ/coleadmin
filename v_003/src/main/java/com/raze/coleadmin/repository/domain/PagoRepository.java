package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaSpecificationExecutor<Pago>, JpaRepository<Pago, Long> {
}
