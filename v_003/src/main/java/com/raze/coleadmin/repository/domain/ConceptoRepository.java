package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptoRepository extends JpaRepository<Concepto, Long>, JpaSpecificationExecutor<Concepto> {
}
