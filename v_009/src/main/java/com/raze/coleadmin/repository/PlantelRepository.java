package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Plantel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Plantel.class)
public interface PlantelRepository extends JpaSpecificationExecutor<Plantel>, JpaRepository<Plantel, Long> {
}
