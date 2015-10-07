package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Curso;
import com.raze.coleadmin.repository.CursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {

	@Autowired
    CursoRepository cursoRepository;

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
        cursoRepository.save(curso);
    }

	public Curso updateCurso(Curso curso) {
        return cursoRepository.save(curso);
    }
}
