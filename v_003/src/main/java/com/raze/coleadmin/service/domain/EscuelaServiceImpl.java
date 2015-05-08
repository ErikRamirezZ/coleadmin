package com.raze.coleadmin.service.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Escuela;
import com.raze.coleadmin.repository.domain.EscuelaRepository;
import com.raze.coleadmin.util.Authenticated;

@Service
@Transactional
public class EscuelaServiceImpl implements EscuelaService {

	@Autowired
    EscuelaRepository escuelaRepository;
	
	Date date = new Date();

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
		escuela.setUsuario(Authenticated.getUsuario());
		escuela.setFechaCreacion(date);
		escuela.setActivo(true);
        escuelaRepository.save(escuela);
    }

	public Escuela updateEscuela(Escuela escuela) {
		escuela.setUsuario(Authenticated.getUsuario());
		escuela.setFechaModificacion(date);
		escuela.setActivo(true);
        return escuelaRepository.save(escuela);
    }
	
	public Escuela logicalDeleteEscuela(Escuela escuela) {
		escuela.setUsuario(Authenticated.getUsuario());
		escuela.setFechaModificacion(date);
		escuela.setActivo(false);
        return escuelaRepository.save(escuela);
    }
	

}
