package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Curso;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Curso.class)
public interface CursoRepository {
}
