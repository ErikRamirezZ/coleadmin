package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.ConfiguracionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionCursoRepository extends JpaSpecificationExecutor<ConfiguracionCurso>, JpaRepository<ConfiguracionCurso, Long> {
}
