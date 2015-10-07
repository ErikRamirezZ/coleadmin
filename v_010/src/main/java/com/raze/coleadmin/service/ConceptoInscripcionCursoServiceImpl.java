package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import com.raze.coleadmin.repository.ConceptoInscripcionCursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConceptoInscripcionCursoServiceImpl implements ConceptoInscripcionCursoService {

	@Autowired
    ConceptoInscripcionCursoRepository conceptoInscripcionCursoRepository;

	public long countAllConceptoInscripcionCursoes() {
        return conceptoInscripcionCursoRepository.count();
    }

	public void deleteConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso) {
        conceptoInscripcionCursoRepository.delete(conceptoInscripcionCurso);
    }

	public ConceptoInscripcionCurso findConceptoInscripcionCurso(Long id) {
        return conceptoInscripcionCursoRepository.findOne(id);
    }

	public List<ConceptoInscripcionCurso> findAllConceptoInscripcionCursoes() {
        return conceptoInscripcionCursoRepository.findAll();
    }

	public List<ConceptoInscripcionCurso> findConceptoInscripcionCursoEntries(int firstResult, int maxResults) {
        return conceptoInscripcionCursoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso) {
        conceptoInscripcionCursoRepository.save(conceptoInscripcionCurso);
    }

	public ConceptoInscripcionCurso updateConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso) {
        return conceptoInscripcionCursoRepository.save(conceptoInscripcionCurso);
    }
}
