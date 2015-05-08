package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Repeticiones;
import com.raze.coleadmin.repository.domain.RepeticionesRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RepeticionesServiceImpl implements RepeticionesService {

	@Autowired
    RepeticionesRepository repeticionesRepository;
	
	private Date date = new Date();

	public long countAllRepeticioneses() {
        return repeticionesRepository.count();
    }

	public void deleteRepeticiones(Repeticiones repeticiones) {
        repeticionesRepository.delete(repeticiones);
    }

	public Repeticiones findRepeticiones(Long id) {
        return repeticionesRepository.findOne(id);
    }

	public List<Repeticiones> findAllRepeticioneses() {
        return repeticionesRepository.findAll();
    }

	public List<Repeticiones> findRepeticionesEntries(int firstResult, int maxResults) {
        return repeticionesRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveRepeticiones(Repeticiones repeticiones) {
		repeticiones.setUsuario(Authenticated.getUsuario());
		repeticiones.setFechaCreacion(date);
		repeticiones.setActivo(true);
        repeticionesRepository.save(repeticiones);
    }

	public Repeticiones updateRepeticiones(Repeticiones repeticiones) {
		repeticiones.setUsuario(Authenticated.getUsuario());
		repeticiones.setFechaModificacion(date);
		repeticiones.setActivo(true);
        return repeticionesRepository.save(repeticiones);
    }
	
	public Repeticiones logicalDeleteRepeticiones(Repeticiones repeticiones) {
		repeticiones.setUsuario(Authenticated.getUsuario());
		repeticiones.setFechaModificacion(date);
		repeticiones.setActivo(false);
        return repeticionesRepository.save(repeticiones);
    }
	
}
