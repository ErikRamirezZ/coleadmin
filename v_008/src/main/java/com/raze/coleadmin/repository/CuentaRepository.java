package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CuentaRepository extends JpaSpecificationExecutor<Cuenta>, JpaRepository<Cuenta, Long> {
}
