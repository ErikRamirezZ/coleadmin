package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.Repeticiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepeticionesRepository extends JpaRepository<Repeticiones, Long>, JpaSpecificationExecutor<Repeticiones> {
}
