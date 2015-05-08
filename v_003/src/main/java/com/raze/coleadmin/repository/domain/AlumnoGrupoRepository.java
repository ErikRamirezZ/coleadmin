package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.AlumnoGrupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoGrupoRepository extends JpaSpecificationExecutor<AlumnoGrupo>, JpaRepository<AlumnoGrupo, Long> {
}
