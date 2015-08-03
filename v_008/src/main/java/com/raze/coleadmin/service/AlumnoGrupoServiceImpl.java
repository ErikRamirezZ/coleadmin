package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.email.NotificationServiceImpl;
import com.raze.coleadmin.repository.AlumnoGrupoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlumnoGrupoServiceImpl implements AlumnoGrupoService {

	@Autowired
    AlumnoGrupoRepository alumnoGrupoRepository;
	
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
//		try {
//			NotificationServiceImpl mail = new NotificationServiceImpl();
//			mail.
//			mail.sendMessage("eramirezz0201@gmail.com", "Correo de Pruebass");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
        alumnoGrupoRepository.save(alumnoGrupo);
    }

	public AlumnoGrupo updateAlumnoGrupo(AlumnoGrupo alumnoGrupo) {
        return alumnoGrupoRepository.save(alumnoGrupo);
    }
}
