package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Domicilio;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Domicilio.class)
public interface DomicilioRepository {
}
