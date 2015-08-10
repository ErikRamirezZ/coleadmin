package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Padre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PadreRepository extends JpaSpecificationExecutor<Padre>, JpaRepository<Padre, Long> {

	Padre findByCorreoE(String correoE);
	
}
