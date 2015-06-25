package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long>, JpaSpecificationExecutor<Permiso> {
}
