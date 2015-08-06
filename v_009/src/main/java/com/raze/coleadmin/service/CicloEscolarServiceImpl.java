package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.repository.CicloEscolarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CicloEscolarServiceImpl implements CicloEscolarService {

	@Autowired
    CicloEscolarRepository cicloEscolarRepository;

	public long countAllCicloEscolars() {
        return cicloEscolarRepository.count();
    }

	public void deleteCicloEscolar(CicloEscolar cicloEscolar) {
        cicloEscolarRepository.delete(cicloEscolar);
    }

	public CicloEscolar findCicloEscolar(Long id) {
        return cicloEscolarRepository.findOne(id);
    }

	public List<CicloEscolar> findAllCicloEscolars() {
        return cicloEscolarRepository.findAll();
    }

	public List<CicloEscolar> findCicloEscolarEntries(int firstResult, int maxResults) {
        return cicloEscolarRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCicloEscolar(CicloEscolar cicloEscolar) {
        cicloEscolarRepository.save(cicloEscolar);
    }

	public CicloEscolar updateCicloEscolar(CicloEscolar cicloEscolar) {
        return cicloEscolarRepository.save(cicloEscolar);
    }
}
