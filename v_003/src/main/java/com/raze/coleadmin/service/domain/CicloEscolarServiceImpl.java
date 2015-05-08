package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.CicloEscolar;
import com.raze.coleadmin.repository.domain.CicloEscolarRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CicloEscolarServiceImpl implements CicloEscolarService {

	@Autowired
    CicloEscolarRepository cicloEscolarRepository;
	
	Date date = new Date();

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
		cicloEscolar.setUsuario(Authenticated.getUsuario());
		cicloEscolar.setFechaCreacion(date);
		cicloEscolar.setActivo(true);
        cicloEscolarRepository.save(cicloEscolar);
    }

	public CicloEscolar updateCicloEscolar(CicloEscolar cicloEscolar) {
		cicloEscolar.setUsuario(Authenticated.getUsuario());
		cicloEscolar.setFechaModificacion(date);
		cicloEscolar.setActivo(true);
        return cicloEscolarRepository.save(cicloEscolar);
    }
	
	public CicloEscolar logicalDeleteCicloEscolar(CicloEscolar cicloEscolar) {
		cicloEscolar.setUsuario(Authenticated.getUsuario());
		cicloEscolar.setFechaModificacion(date);
		cicloEscolar.setActivo(true);
        return cicloEscolarRepository.save(cicloEscolar);
    }

}
