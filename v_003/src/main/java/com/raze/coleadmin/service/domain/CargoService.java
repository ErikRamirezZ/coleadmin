package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.Cargo;
import java.util.List;

public interface CargoService {

	public abstract long countAllCargoes();


	public abstract void deleteCargo(Cargo cargo);


	public abstract Cargo findCargo(Long id);


	public abstract List<Cargo> findAllCargoes();


	public abstract List<Cargo> findCargoEntries(int firstResult, int maxResults);


	public abstract void saveCargo(Cargo cargo);


	public abstract Cargo updateCargo(Cargo cargo);


	public abstract Cargo logicalDeleteCargo(Cargo cargo);

}
