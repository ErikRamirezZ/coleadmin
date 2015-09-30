package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Salon;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Salon.class)
public interface SalonRepository {
}
