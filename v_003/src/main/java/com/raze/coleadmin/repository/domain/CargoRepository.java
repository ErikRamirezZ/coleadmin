package com.raze.coleadmin.repository.domain;
import com.raze.coleadmin.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaSpecificationExecutor<Cargo>, JpaRepository<Cargo, Long> {
}
