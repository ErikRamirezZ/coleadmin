package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Plantel;
import java.util.List;

public interface PlantelService {

	public abstract long countAllPlantels();


	public abstract void deletePlantel(Plantel plantel);


	public abstract Plantel findPlantel(Long id);


	public abstract List<Plantel> findAllPlantels();


	public abstract List<Plantel> findPlantelEntries(int firstResult, int maxResults);


	public abstract void savePlantel(Plantel plantel);


	public abstract Plantel updatePlantel(Plantel plantel);

}
