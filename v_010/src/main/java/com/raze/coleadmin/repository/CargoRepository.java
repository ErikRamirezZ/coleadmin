package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Cargo;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Cargo.class)
public interface CargoRepository {
}
