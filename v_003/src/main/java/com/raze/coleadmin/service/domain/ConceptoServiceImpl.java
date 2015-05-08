package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Concepto;
import com.raze.coleadmin.repository.domain.ConceptoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConceptoServiceImpl implements ConceptoService {

	@Autowired
    ConceptoRepository conceptoRepository;
	
	Date date = new Date();

	public long countAllConceptoes() {
        return conceptoRepository.count();
    }

	public void deleteConcepto(Concepto concepto) {
        conceptoRepository.delete(concepto);
    }

	public Concepto findConcepto(Long id) {
        return conceptoRepository.findOne(id);
    }

	public List<Concepto> findAllConceptoes() {
        return conceptoRepository.findAll();
    }

	public List<Concepto> findConceptoEntries(int firstResult, int maxResults) {
        return conceptoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveConcepto(Concepto concepto) {
		concepto.setUsuario(Authenticated.getUsuario());
		concepto.setFechaCreacion(date);
		concepto.setActivo(true);
        conceptoRepository.save(concepto);
    }

	public Concepto updateConcepto(Concepto concepto) {
		concepto.setUsuario(Authenticated.getUsuario());
		concepto.setFechaModificacion(date);
		concepto.setActivo(true);
        return conceptoRepository.save(concepto);
    }

	public Concepto logicalDeleteConcepto(Concepto concepto) {
		concepto.setUsuario(Authenticated.getUsuario());
		concepto.setFechaModificacion(date);
		concepto.setActivo(false);
        return conceptoRepository.save(concepto);
    }

}
