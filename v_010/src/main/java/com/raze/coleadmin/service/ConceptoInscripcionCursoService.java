package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.ConceptoInscripcionCurso.class })
public interface ConceptoInscripcionCursoService {

	public abstract long countAllConceptoInscripcionCursoes();


	public abstract void deleteConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso);


	public abstract ConceptoInscripcionCurso findConceptoInscripcionCurso(Long id);


	public abstract List<ConceptoInscripcionCurso> findAllConceptoInscripcionCursoes();


	public abstract List<ConceptoInscripcionCurso> findConceptoInscripcionCursoEntries(int firstResult, int maxResults);


	public abstract void saveConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso);


	public abstract ConceptoInscripcionCurso updateConceptoInscripcionCurso(ConceptoInscripcionCurso conceptoInscripcionCurso);

}
