package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Docente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long>, JpaSpecificationExecutor<Docente> {

	Docente findByCorreoE(String correoE);
	
}
