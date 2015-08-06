package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Personal;
import com.raze.coleadmin.repository.PersonalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonalServiceImpl implements PersonalService {

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
        personalRepository.save(personal);
    }

	public Personal updatePersonal(Personal personal) {
        return personalRepository.save(personal);
    }
}
