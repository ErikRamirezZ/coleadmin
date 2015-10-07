package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.CorreoNotificaciones;
import com.raze.coleadmin.repository.CorreoNotificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorreoNotificacionesServiceImpl implements CorreoNotificacionesService {

	@Autowired
    CorreoNotificacionesRepository correoNotificacionesRepository;

	public long countAllCorreoNotificacioneses() {
        return correoNotificacionesRepository.count();
    }

	public void deleteCorreoNotificaciones(CorreoNotificaciones correoNotificaciones) {
        correoNotificacionesRepository.delete(correoNotificaciones);
    }

	public CorreoNotificaciones findCorreoNotificaciones(Long id) {
        return correoNotificacionesRepository.findOne(id);
    }

	public List<CorreoNotificaciones> findAllCorreoNotificacioneses() {
        return correoNotificacionesRepository.findAll();
    }

	public List<CorreoNotificaciones> findCorreoNotificacionesEntries(int firstResult, int maxResults) {
        return correoNotificacionesRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCorreoNotificaciones(CorreoNotificaciones correoNotificaciones) {
        correoNotificacionesRepository.save(correoNotificaciones);
    }

	public CorreoNotificaciones updateCorreoNotificaciones(CorreoNotificaciones correoNotificaciones) {
        return correoNotificacionesRepository.save(correoNotificaciones);
    }
}
