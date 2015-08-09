package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Padre.class)
public interface PadreRepository extends JpaSpecificationExecutor<Padre>, JpaRepository<Padre, Long> {
}
