package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Domicilio;
import com.raze.coleadmin.repository.DomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DomicilioServiceImpl implements DomicilioService {

	@Autowired
    DomicilioRepository domicilioRepository;

	public long countAllDomicilios() {
        return domicilioRepository.count();
    }

	public void deleteDomicilio(Domicilio domicilio) {
        domicilioRepository.delete(domicilio);
    }

	public Domicilio findDomicilio(Long id) {
        return domicilioRepository.findOne(id);
    }

	public List<Domicilio> findAllDomicilios() {
        return domicilioRepository.findAll();
    }

	public List<Domicilio> findDomicilioEntries(int firstResult, int maxResults) {
        return domicilioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

	public Domicilio updateDomicilio(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }
}
