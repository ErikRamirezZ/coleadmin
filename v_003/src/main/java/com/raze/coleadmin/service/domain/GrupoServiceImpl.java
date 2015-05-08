package com.raze.coleadmin.service.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.repository.domain.GrupoRepository;
import com.raze.coleadmin.util.Authenticated;

@Service
@Transactional
public class GrupoServiceImpl implements GrupoService {

	@Autowired
    GrupoRepository grupoRepository;
	
	Date date = new Date();

	public long countAllGrupoes() {
        return grupoRepository.count();
    }

	public void deleteGrupo(Grupo grupo) {
        grupoRepository.delete(grupo);
    }

	public Grupo findGrupo(Long id) {
        return grupoRepository.findOne(id);
    }

	public List<Grupo> findAllGrupoes() {
        return grupoRepository.findAll();
    }

	public List<Grupo> findGrupoEntries(int firstResult, int maxResults) {
        return grupoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveGrupo(Grupo grupo) {
		grupo.setUsuario(Authenticated.getUsuario());
		grupo.setFechaCreacion(date);
		grupo.setActivo(true);
        grupoRepository.save(grupo);
    }

	public Grupo updateGrupo(Grupo grupo) {
		grupo.setUsuario(Authenticated.getUsuario());
		grupo.setFechaModificacion(date);
		grupo.setActivo(true);
        return grupoRepository.save(grupo);
    }
	
	public Grupo logicalDeleteGrupo(Grupo grupo) {
		grupo.setUsuario(Authenticated.getUsuario());
		grupo.setFechaModificacion(date);
		grupo.setActivo(false);
        return grupoRepository.save(grupo);
    }
	
}
