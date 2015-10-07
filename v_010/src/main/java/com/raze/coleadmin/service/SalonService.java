package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Salon;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Salon.class })
public interface SalonService {

	public abstract long countAllSalons();


	public abstract void deleteSalon(Salon salon);


	public abstract Salon findSalon(Long id);


	public abstract List<Salon> findAllSalons();


	public abstract List<Salon> findSalonEntries(int firstResult, int maxResults);


	public abstract void saveSalon(Salon salon);


	public abstract Salon updateSalon(Salon salon);

}
