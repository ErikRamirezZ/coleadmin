package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.Correo;
import com.raze.coleadmin.repository.CorreoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CorreoServiceImpl implements CorreoService {

	@Autowired
    CorreoRepository correoRepository;

	public long countAllCorreos() {
        return correoRepository.count();
    }

	public void deleteCorreo(Correo correo) {
        correoRepository.delete(correo);
    }

	public Correo findCorreo(Long id) {
        return correoRepository.findOne(id);
    }

	public List<Correo> findAllCorreos() {
        return correoRepository.findAll();
    }

	public List<Correo> findCorreoEntries(int firstResult, int maxResults) {
        return correoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCorreo(Correo correo) {
        correoRepository.save(correo);
    }

	public Correo updateCorreo(Correo correo) {
        return correoRepository.save(correo);
    }
}
