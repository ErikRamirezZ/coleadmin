package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Escuela;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Escuela.class)
public interface EscuelaRepository {
}
