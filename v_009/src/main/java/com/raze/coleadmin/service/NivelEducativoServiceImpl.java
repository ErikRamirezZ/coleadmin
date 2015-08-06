package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.NivelEducativo;
import com.raze.coleadmin.repository.NivelEducativoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NivelEducativoServiceImpl implements NivelEducativoService {

	@Autowired
    NivelEducativoRepository nivelEducativoRepository;

	public long countAllNivelEducativoes() {
        return nivelEducativoRepository.count();
    }

	public void deleteNivelEducativo(NivelEducativo nivelEducativo) {
        nivelEducativoRepository.delete(nivelEducativo);
    }

	public NivelEducativo findNivelEducativo(Long id) {
        return nivelEducativoRepository.findOne(id);
    }

	public List<NivelEducativo> findAllNivelEducativoes() {
        return nivelEducativoRepository.findAll();
    }

	public List<NivelEducativo> findNivelEducativoEntries(int firstResult, int maxResults) {
        return nivelEducativoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveNivelEducativo(NivelEducativo nivelEducativo) {
        nivelEducativoRepository.save(nivelEducativo);
    }

	public NivelEducativo updateNivelEducativo(NivelEducativo nivelEducativo) {
        return nivelEducativoRepository.save(nivelEducativo);
    }
}
