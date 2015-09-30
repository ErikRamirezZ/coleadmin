package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Concepto;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Concepto.class)
public interface ConceptoRepository {
}
