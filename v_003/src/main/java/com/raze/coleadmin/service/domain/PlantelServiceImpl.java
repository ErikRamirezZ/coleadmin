package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Plantel;
import com.raze.coleadmin.repository.domain.PlantelRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PlantelServiceImpl implements PlantelService {

	@Autowired
    PlantelRepository plantelRepository;
	
	private Date date = new Date();

	public long countAllPlantels() {
        return plantelRepository.count();
    }

	public void deletePlantel(Plantel plantel) {
        plantelRepository.delete(plantel);
    }

	public Plantel findPlantel(Long id) {
        return plantelRepository.findOne(id);
    }

	public List<Plantel> findAllPlantels() {
        return plantelRepository.findAll();
    }

	public List<Plantel> findPlantelEntries(int firstResult, int maxResults) {
        return plantelRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePlantel(Plantel plantel) {
		plantel.setUsuario(Authenticated.getUsuario());
		plantel.setFechaCreacion(date);
		plantel.setActivo(true);
        plantelRepository.save(plantel);
    }

	public Plantel updatePlantel(Plantel plantel) {
		plantel.setUsuario(Authenticated.getUsuario());
		plantel.setFechaModificacion(date);
		plantel.setActivo(true);
        return plantelRepository.save(plantel);
    }
	
	public Plantel logicalDeletePlantel(Plantel plantel) {
		plantel.setUsuario(Authenticated.getUsuario());
		plantel.setFechaModificacion(date);
		plantel.setActivo(false);
        return plantelRepository.save(plantel);
    }
	
}
