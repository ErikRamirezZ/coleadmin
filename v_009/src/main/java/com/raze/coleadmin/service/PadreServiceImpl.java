package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Padre;
import com.raze.coleadmin.repository.PadreRepository;
import com.raze.coleadmin.util.UserLoginData;

import java.util.Date;
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

	public void logicalDeletePadre(Padre padre) {
		padre.setUsuarioModifica(UserLoginData.getIdUsername());
		padre.setFechaModificacion(new Date());
		padre.setActivo(false);
        padreRepository.save(padre);
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
		padre.setUsuarioCrea(UserLoginData.getIdUsername());
		padre.setFechaCreacion(new Date());
		padre.setActivo(true);
        padreRepository.save(padre);
    }

	public Padre updatePadre(Padre padre) {
		padre.setUsuarioModifica(UserLoginData.getIdUsername());
		padre.setFechaModificacion(new Date());
		padre.setActivo(true);
        return padreRepository.save(padre);
    }

	@Override
	public Padre findPadreByCorreoE(String correoE) {
		return padreRepository.findByCorreoE(correoE);
	}
}
