package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>, JpaSpecificationExecutor<Rol> {

	Rol findByNombreRol(String nombreRol);
	
}
