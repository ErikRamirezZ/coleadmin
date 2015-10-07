package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.Contacto;
import com.raze.coleadmin.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactoServiceImpl implements ContactoService {

	@Autowired
    ContactoRepository contactoRepository;

	public long countAllContactoes() {
        return contactoRepository.count();
    }

	public void deleteContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
    }

	public Contacto findContacto(Long id) {
        return contactoRepository.findOne(id);
    }

	public List<Contacto> findAllContactoes() {
        return contactoRepository.findAll();
    }

	public List<Contacto> findContactoEntries(int firstResult, int maxResults) {
        return contactoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }

	public Contacto updateContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }
}
