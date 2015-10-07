package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.EstatusCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = EstatusCargo.class)
public interface EstatusCargoRepository extends JpaSpecificationExecutor<EstatusCargo>, JpaRepository<EstatusCargo, Long> {
}
