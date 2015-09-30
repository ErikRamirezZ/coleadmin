package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Alumno;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Alumno.class)
public interface AlumnoRepository {
}
