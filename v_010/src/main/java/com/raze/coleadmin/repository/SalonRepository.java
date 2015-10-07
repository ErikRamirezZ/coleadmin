package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Salon.class)
public interface SalonRepository extends JpaSpecificationExecutor<Salon>, JpaRepository<Salon, Long> {
}
