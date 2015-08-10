package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaSpecificationExecutor<Grupo>, JpaRepository<Grupo, Long> {
}
