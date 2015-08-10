package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Personal;

import java.util.List;

public interface PersonalService {

	public abstract long countAllPersonals();


	public abstract void deletePersonal(Personal personal);


	public abstract Personal findPersonal(Long id);


	public abstract List<Personal> findAllPersonals();


	public abstract List<Personal> findPersonalEntries(int firstResult, int maxResults);


	public abstract void savePersonal(Personal personal);


	public abstract Personal updatePersonal(Personal personal);


	public abstract Personal findPersonalByCorreoE(String correoE);

}
