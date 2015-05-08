package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaRepository<Modulo, Long>, JpaSpecificationExecutor<Modulo> {
}
