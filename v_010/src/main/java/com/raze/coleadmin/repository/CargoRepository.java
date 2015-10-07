package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Cargo.class)
public interface CargoRepository extends JpaSpecificationExecutor<Cargo>, JpaRepository<Cargo, Long> {
}
