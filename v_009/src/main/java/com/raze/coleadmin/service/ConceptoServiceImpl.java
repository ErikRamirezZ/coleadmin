package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.repository.ConceptoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ConceptoServiceImpl implements ConceptoService {

	@Autowired
    ConceptoRepository conceptoRepository;

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
        conceptoRepository.save(concepto);
    }

	public Concepto updateConcepto(Concepto concepto) {
        return conceptoRepository.save(concepto);
    }
}
