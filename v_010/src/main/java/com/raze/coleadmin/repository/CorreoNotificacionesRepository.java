package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@RooJpaRepository(domainType = CorreoNotificaciones.class)
public interface CorreoNotificacionesRepository extends JpaSpecificationExecutor<CorreoNotificaciones>, JpaRepository<CorreoNotificaciones, Long> {
}
