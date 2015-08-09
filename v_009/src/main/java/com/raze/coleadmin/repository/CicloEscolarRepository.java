package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.CicloEscolar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = CicloEscolar.class)
public interface CicloEscolarRepository extends JpaSpecificationExecutor<CicloEscolar>, JpaRepository<CicloEscolar, Long> {
}
