package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.repository.domain.AsistenciaRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AsistenciaServiceImpl implements AsistenciaService {

	@Autowired
    AsistenciaRepository asistenciaRepository;
	
	private Date date = new Date();

	public long countAllAsistencias() {
        return asistenciaRepository.count();
    }

	public void deleteAsistencia(Asistencia asistencia) {
        asistenciaRepository.delete(asistencia);
    }

	public Asistencia findAsistencia(Long id) {
        return asistenciaRepository.findOne(id);
    }

	public List<Asistencia> findAllAsistencias() {
        return asistenciaRepository.findAll();
    }

	public List<Asistencia> findAsistenciaEntries(int firstResult, int maxResults) {
        return asistenciaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAsistencia(Asistencia asistencia) {
		asistencia.setUsuario(Authenticated.getUsuario());
		asistencia.setFechaCreacion(date);
		asistencia.setActivo(true);
        asistenciaRepository.save(asistencia);
    }

	public Asistencia updateAsistencia(Asistencia asistencia) {
		asistencia.setUsuario(Authenticated.getUsuario());
		asistencia.setFechaModificacion(date);
		asistencia.setActivo(true);
        return asistenciaRepository.save(asistencia);
    }
	
	public Asistencia logicalDeleteAsistencia(Asistencia asistencia) {
		asistencia.setUsuario(Authenticated.getUsuario());
		asistencia.setFechaModificacion(date);
		asistencia.setActivo(false);
        return asistenciaRepository.save(asistencia);
    }
		
}
