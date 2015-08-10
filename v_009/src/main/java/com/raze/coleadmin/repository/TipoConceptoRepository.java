package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.TipoConcepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConceptoRepository extends JpaRepository<TipoConcepto, Long>, JpaSpecificationExecutor<TipoConcepto> {
}
