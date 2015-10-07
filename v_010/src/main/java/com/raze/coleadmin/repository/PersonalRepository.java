package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Personal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = Personal.class)
public interface PersonalRepository extends JpaSpecificationExecutor<Personal>, JpaRepository<Personal, Long> {
}
