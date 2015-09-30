package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Personal;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Personal.class)
public interface PersonalRepository {
}
