package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = ConceptoInscripcionCurso.class)
public interface ConceptoInscripcionCursoRepository extends JpaSpecificationExecutor<ConceptoInscripcionCurso>, JpaRepository<ConceptoInscripcionCurso, Long> {
}
