package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Personal;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Personal.class })
public interface PersonalService {

	public abstract long countAllPersonals();


	public abstract void deletePersonal(Personal personal);


	public abstract Personal findPersonal(Long id);


	public abstract List<Personal> findAllPersonals();


	public abstract List<Personal> findPersonalEntries(int firstResult, int maxResults);


	public abstract void savePersonal(Personal personal);


	public abstract Personal updatePersonal(Personal personal);

}
