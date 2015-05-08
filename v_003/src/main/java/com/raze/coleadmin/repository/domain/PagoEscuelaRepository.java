package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.PagoEscuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoEscuelaRepository extends JpaRepository<PagoEscuela, Long>, JpaSpecificationExecutor<PagoEscuela> {
}
