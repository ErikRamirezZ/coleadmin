package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = CorreoNotificaciones.class)
public interface CorreoNotificacionesRepository {
}
