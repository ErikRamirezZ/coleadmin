package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.repository.AsistenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AsistenciaServiceImpl implements AsistenciaService {

	@Autowired
    AsistenciaRepository asistenciaRepository;

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
        asistenciaRepository.save(asistencia);
    }

	public Asistencia updateAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }
}
