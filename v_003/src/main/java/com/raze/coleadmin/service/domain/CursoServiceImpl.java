package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.repository.domain.CursoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
    CursoRepository cursoRepository;
	
	Date date = new Date();

	public long countAllCursoes() {
        return cursoRepository.count();
    }

	public void deleteCurso(Curso curso) {
        cursoRepository.delete(curso);
    }

	public Curso findCurso(Long id) {
        return cursoRepository.findOne(id);
    }

	public List<Curso> findAllCursoes() {
        return cursoRepository.findAll();
    }

	public List<Curso> findCursoEntries(int firstResult, int maxResults) {
        return cursoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCurso(Curso curso) {
		curso.setUsuario(Authenticated.getUsuario());
		curso.setFechaCreacion(date);
		curso.setActivo(true);
        cursoRepository.save(curso);
    }

	public Curso updateCurso(Curso curso) {
		curso.setUsuario(Authenticated.getUsuario());
		curso.setFechaModificacion(date);
		curso.setActivo(true);
        return cursoRepository.save(curso);
    }

	public Curso logicalDeleteCurso(Curso curso) {
		curso.setUsuario(Authenticated.getUsuario());
		curso.setFechaModificacion(date);
		curso.setActivo(false);
        return cursoRepository.save(curso);
    }
	
}
