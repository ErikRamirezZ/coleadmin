package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaSpecificationExecutor<Alumno>, JpaRepository<Alumno, Long> {

	Alumno findByCorreoE(String correoe);
}
