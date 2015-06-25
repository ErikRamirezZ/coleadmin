package com.raze.coleadmin.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Personal;
import com.raze.coleadmin.repository.PersonalRepository;

@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

	static Logger log = LoggerFactory.getLogger(PersonalServiceImpl.class);
	
	@Autowired
    PersonalRepository personalRepository;

	public long countAllPersonals() {
        return personalRepository.count();
    }

	public void deletePersonal(Personal personal) {
        personalRepository.delete(personal);
    }

	public Personal findPersonal(Long id) {
        return personalRepository.findOne(id);
    }

	public List<Personal> findAllPersonals() {
        return personalRepository.findAll();
    }

	public List<Personal> findPersonalEntries(int firstResult, int maxResults) {
        return personalRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePersonal(Personal personal) {
		getCurrentUsaurio();
		personal.setFechaCreacion(new Date());
		personal.setActivo(true);
        personalRepository.save(personal);
    }

	public Personal updatePersonal(Personal personal) {
		getCurrentUsaurio();
		personal.setFechaModificacion(new Date());
        return personalRepository.save(personal);
    }
	
	public Personal logicalDeletePersonal(Personal personal) {
		personal.setFechaModificacion(new Date());
		personal.setActivo(false);
        return personalRepository.save(personal);
    }
	
	
	private void getCurrentUsaurio(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		log.info("princial" + principal);
		log.info("princial.toString()" + principal.toString());
		
		if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		} else {
		  String username = principal.toString();
		}
	}
	
}
