package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.EstatusInscripcion;
import com.raze.coleadmin.repository.EstatusInscripcionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstatusInscripcionServiceImpl implements EstatusInscripcionService {

	@Autowired
    EstatusInscripcionRepository estatusInscripcionRepository;

	public long countAllEstatusInscripcions() {
        return estatusInscripcionRepository.count();
    }

	public void deleteEstatusInscripcion(EstatusInscripcion estatusInscripcion) {
        estatusInscripcionRepository.delete(estatusInscripcion);
    }

	public EstatusInscripcion findEstatusInscripcion(Long id) {
        return estatusInscripcionRepository.findOne(id);
    }

	public List<EstatusInscripcion> findAllEstatusInscripcions() {
        return estatusInscripcionRepository.findAll();
    }

	public List<EstatusInscripcion> findEstatusInscripcionEntries(int firstResult, int maxResults) {
        return estatusInscripcionRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEstatusInscripcion(EstatusInscripcion estatusInscripcion) {
        estatusInscripcionRepository.save(estatusInscripcion);
    }

	public EstatusInscripcion updateEstatusInscripcion(EstatusInscripcion estatusInscripcion) {
        return estatusInscripcionRepository.save(estatusInscripcion);
    }
}
