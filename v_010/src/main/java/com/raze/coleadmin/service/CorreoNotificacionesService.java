package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.CorreoNotificaciones.class })
public interface CorreoNotificacionesService {

	public abstract long countAllCorreoNotificacioneses();


	public abstract void deleteCorreoNotificaciones(CorreoNotificaciones correoNotificaciones);


	public abstract CorreoNotificaciones findCorreoNotificaciones(Long id);


	public abstract List<CorreoNotificaciones> findAllCorreoNotificacioneses();


	public abstract List<CorreoNotificaciones> findCorreoNotificacionesEntries(int firstResult, int maxResults);


	public abstract void saveCorreoNotificaciones(CorreoNotificaciones correoNotificaciones);


	public abstract CorreoNotificaciones updateCorreoNotificaciones(CorreoNotificaciones correoNotificaciones);

}
