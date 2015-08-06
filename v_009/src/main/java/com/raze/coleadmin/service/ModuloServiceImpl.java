package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.Modulo;
import com.raze.coleadmin.repository.ModuloRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuloServiceImpl implements ModuloService {

	@Autowired
    ModuloRepository moduloRepository;

	public long countAllModuloes() {
        return moduloRepository.count();
    }

	public void deleteModulo(Modulo modulo) {
        moduloRepository.delete(modulo);
    }

	public Modulo findModulo(Long id) {
        return moduloRepository.findOne(id);
    }

	public List<Modulo> findAllModuloes() {
        return moduloRepository.findAll();
    }

	public List<Modulo> findModuloEntries(int firstResult, int maxResults) {
        return moduloRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveModulo(Modulo modulo) {
        moduloRepository.save(modulo);
    }

	public Modulo updateModulo(Modulo modulo) {
        return moduloRepository.save(modulo);
    }
}
