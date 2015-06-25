package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.PagoEscuela;
import com.raze.coleadmin.repository.PagoEscuelaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagoEscuelaServiceImpl implements PagoEscuelaService {

	@Autowired
    PagoEscuelaRepository pagoEscuelaRepository;

	public long countAllPagoEscuelas() {
        return pagoEscuelaRepository.count();
    }

	public void deletePagoEscuela(PagoEscuela pagoEscuela) {
        pagoEscuelaRepository.delete(pagoEscuela);
    }

	public PagoEscuela findPagoEscuela(Long id) {
        return pagoEscuelaRepository.findOne(id);
    }

	public List<PagoEscuela> findAllPagoEscuelas() {
        return pagoEscuelaRepository.findAll();
    }

	public List<PagoEscuela> findPagoEscuelaEntries(int firstResult, int maxResults) {
        return pagoEscuelaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePagoEscuela(PagoEscuela pagoEscuela) {
        pagoEscuelaRepository.save(pagoEscuela);
    }

	public PagoEscuela updatePagoEscuela(PagoEscuela pagoEscuela) {
        return pagoEscuelaRepository.save(pagoEscuela);
    }
}
