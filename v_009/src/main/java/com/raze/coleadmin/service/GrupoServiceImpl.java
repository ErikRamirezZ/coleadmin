package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Grupo;
import com.raze.coleadmin.repository.GrupoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GrupoServiceImpl implements GrupoService {

	@Autowired
    GrupoRepository grupoRepository;

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
        grupoRepository.save(grupo);
    }

	public Grupo updateGrupo(Grupo grupo) {
        return grupoRepository.save(grupo);
    }
}
