package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Inscrpcion;
import com.raze.coleadmin.repository.InscrpcionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InscrpcionServiceImpl implements InscrpcionService {

	@Autowired
    InscrpcionRepository inscrpcionRepository;

	public long countAllInscrpcions() {
        return inscrpcionRepository.count();
    }

	public void deleteInscrpcion(Inscrpcion inscrpcion) {
        inscrpcionRepository.delete(inscrpcion);
    }

	public Inscrpcion findInscrpcion(Long id) {
        return inscrpcionRepository.findOne(id);
    }

	public List<Inscrpcion> findAllInscrpcions() {
        return inscrpcionRepository.findAll();
    }

	public List<Inscrpcion> findInscrpcionEntries(int firstResult, int maxResults) {
        return inscrpcionRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveInscrpcion(Inscrpcion inscrpcion) {
        inscrpcionRepository.save(inscrpcion);
    }

	public Inscrpcion updateInscrpcion(Inscrpcion inscrpcion) {
        return inscrpcionRepository.save(inscrpcion);
    }
}
