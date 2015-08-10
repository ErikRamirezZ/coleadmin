package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuloRepository extends JpaSpecificationExecutor<Modulo>, JpaRepository<Modulo, Long> {
}
