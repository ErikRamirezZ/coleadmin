package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Docente;
import com.raze.coleadmin.repository.DocenteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DocenteServiceImpl implements DocenteService {

	@Autowired
    DocenteRepository docenteRepository;

	public long countAllDocentes() {
        return docenteRepository.count();
    }

	public void deleteDocente(Docente docente) {
        docenteRepository.delete(docente);
    }

	public Docente findDocente(Long id) {
        return docenteRepository.findOne(id);
    }

	public List<Docente> findAllDocentes() {
        return docenteRepository.findAll();
    }

	public List<Docente> findDocenteEntries(int firstResult, int maxResults) {
        return docenteRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveDocente(Docente docente) {
        docenteRepository.save(docente);
    }

	public Docente updateDocente(Docente docente) {
        return docenteRepository.save(docente);
    }
}
