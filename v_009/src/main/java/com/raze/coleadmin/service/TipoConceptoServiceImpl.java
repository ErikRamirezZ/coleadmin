package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.TipoConcepto;
import com.raze.coleadmin.repository.TipoConceptoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoConceptoServiceImpl implements TipoConceptoService {

	@Autowired
    TipoConceptoRepository tipoConceptoRepository;

	public long countAllTipoConceptoes() {
        return tipoConceptoRepository.count();
    }

	public void deleteTipoConcepto(TipoConcepto tipoConcepto) {
        tipoConceptoRepository.delete(tipoConcepto);
    }

	public TipoConcepto findTipoConcepto(Long id) {
        return tipoConceptoRepository.findOne(id);
    }

	public List<TipoConcepto> findAllTipoConceptoes() {
        return tipoConceptoRepository.findAll();
    }

	public List<TipoConcepto> findTipoConceptoEntries(int firstResult, int maxResults) {
        return tipoConceptoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveTipoConcepto(TipoConcepto tipoConcepto) {
        tipoConceptoRepository.save(tipoConcepto);
    }

	public TipoConcepto updateTipoConcepto(TipoConcepto tipoConcepto) {
        return tipoConceptoRepository.save(tipoConcepto);
    }
}
