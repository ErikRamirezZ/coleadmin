package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Modulo;
import com.raze.coleadmin.repository.domain.ModuloRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ModuloServiceImpl implements ModuloService {

	@Autowired
    ModuloRepository moduloRepository;
	
	private Date date = new Date();

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
		modulo.setUsuario(Authenticated.getUsuario());
		modulo.setFechaCreacion(date);
		modulo.setActivo(true);
        moduloRepository.save(modulo);
    }

	public Modulo updateModulo(Modulo modulo) {
		modulo.setUsuario(Authenticated.getUsuario());
		modulo.setFechaModificacion(date);
		modulo.setActivo(true);
        return moduloRepository.save(modulo);
    }
	
	public Modulo logicalDeleteModulo(Modulo modulo) {
		modulo.setUsuario(Authenticated.getUsuario());
		modulo.setFechaModificacion(date);
		modulo.setActivo(false);
        return moduloRepository.save(modulo);
    }
	
}
