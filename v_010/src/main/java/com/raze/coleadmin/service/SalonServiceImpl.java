package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Salon;
import com.raze.coleadmin.repository.SalonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalonServiceImpl implements SalonService {

	@Autowired
    SalonRepository salonRepository;

	public long countAllSalons() {
        return salonRepository.count();
    }

	public void deleteSalon(Salon salon) {
        salonRepository.delete(salon);
    }

	public Salon findSalon(Long id) {
        return salonRepository.findOne(id);
    }

	public List<Salon> findAllSalons() {
        return salonRepository.findAll();
    }

	public List<Salon> findSalonEntries(int firstResult, int maxResults) {
        return salonRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveSalon(Salon salon) {
        salonRepository.save(salon);
    }

	public Salon updateSalon(Salon salon) {
        return salonRepository.save(salon);
    }
}
