package com.raze.coleadmin.service.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Permiso;
import com.raze.coleadmin.repository.domain.PermisoRepository;

@Service
@Transactional
public class PermisoServiceImpl implements PermisoService {

	@Autowired
    PermisoRepository permisoRepository;
	
	public long countAllPermisoes() {
        return permisoRepository.count();
    }

	public void deletePermiso(Permiso permiso) {
        permisoRepository.delete(permiso);
    }

	public Permiso findPermiso(Long id) {
        return permisoRepository.findOne(id);
    }

	public List<Permiso> findAllPermisoes() {
        return permisoRepository.findAll();
    }

	public List<Permiso> findPermisoEntries(int firstResult, int maxResults) {
        return permisoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePermiso(Permiso permiso) {
        permisoRepository.save(permiso);
    }

	public Permiso updatePermiso(Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}
