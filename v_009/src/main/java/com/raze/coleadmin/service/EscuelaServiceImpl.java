package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.repository.EscuelaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EscuelaServiceImpl implements EscuelaService {

	@Autowired
    EscuelaRepository escuelaRepository;

	public long countAllEscuelas() {
        return escuelaRepository.count();
    }

	public void deleteEscuela(Escuela escuela) {
        escuelaRepository.delete(escuela);
    }

	public Escuela findEscuela(Long id) {
        return escuelaRepository.findOne(id);
    }

	public List<Escuela> findAllEscuelas() {
        return escuelaRepository.findAll();
    }

	public List<Escuela> findEscuelaEntries(int firstResult, int maxResults) {
        return escuelaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEscuela(Escuela escuela) {
        escuelaRepository.save(escuela);
    }

	public Escuela updateEscuela(Escuela escuela) {
        return escuelaRepository.save(escuela);
    }
}
