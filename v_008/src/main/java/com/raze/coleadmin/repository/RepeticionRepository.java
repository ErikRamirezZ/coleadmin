package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Repeticion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RepeticionRepository extends JpaSpecificationExecutor<Repeticion>, JpaRepository<Repeticion, Long> {
}
