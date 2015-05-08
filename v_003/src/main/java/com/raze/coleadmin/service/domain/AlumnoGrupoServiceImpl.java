package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.repository.domain.AlumnoGrupoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlumnoGrupoServiceImpl implements AlumnoGrupoService {

	@Autowired
    AlumnoGrupoRepository alumnoGrupoRepository;
	
	Date date = new Date();

	public long countAllAlumnoGrupoes() {
        return alumnoGrupoRepository.count();
    }

	public void deleteAlumnoGrupo(AlumnoGrupo alumnoGrupo) {
        alumnoGrupoRepository.delete(alumnoGrupo);
    }

	public AlumnoGrupo findAlumnoGrupo(Long id) {
        return alumnoGrupoRepository.findOne(id);
    }

	public List<AlumnoGrupo> findAllAlumnoGrupoes() {
        return alumnoGrupoRepository.findAll();
    }

	public List<AlumnoGrupo> findAlumnoGrupoEntries(int firstResult, int maxResults) {
        return alumnoGrupoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveAlumnoGrupo(AlumnoGrupo alumnoGrupo) {
		alumnoGrupo.setUsuario(Authenticated.getUsuario());
		alumnoGrupo.setFechaCreacion(date);
		alumnoGrupo.setActivo(false);
        alumnoGrupoRepository.save(alumnoGrupo);
    }

	public AlumnoGrupo updateAlumnoGrupo(AlumnoGrupo alumnoGrupo) {
		alumnoGrupo.setUsuario(Authenticated.getUsuario());
		alumnoGrupo.setFechaModificacion(date);
		alumnoGrupo.setActivo(false);
        return alumnoGrupoRepository.save(alumnoGrupo);
    }

	@Override
	public AlumnoGrupo logicalDeleteAlumnoGrupo(AlumnoGrupo alumnoGrupo) {
		alumnoGrupo.setUsuario(Authenticated.getUsuario());
		alumnoGrupo.setFechaModificacion(date);
		alumnoGrupo.setActivo(false);
        return alumnoGrupoRepository.save(alumnoGrupo);
    }
}
