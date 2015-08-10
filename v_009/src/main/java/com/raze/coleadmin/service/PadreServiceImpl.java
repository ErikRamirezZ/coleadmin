package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Padre;
import com.raze.coleadmin.repository.PadreRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PadreServiceImpl implements PadreService {

	@Autowired
    PadreRepository padreRepository;

	public long countAllPadres() {
        return padreRepository.count();
    }

	public void deletePadre(Padre padre) {
        padreRepository.delete(padre);
    }

	public Padre findPadre(Long id) {
        return padreRepository.findOne(id);
    }

	public List<Padre> findAllPadres() {
        return padreRepository.findAll();
    }

	public List<Padre> findPadreEntries(int firstResult, int maxResults) {
        return padreRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePadre(Padre padre) {
        padreRepository.save(padre);
    }

	public Padre updatePadre(Padre padre) {
        return padreRepository.save(padre);
    }

	@Override
	public Padre findPadreByCorreoE(String correoE) {
		return padreRepository.findByCorreoE(correoE);
	}
}
