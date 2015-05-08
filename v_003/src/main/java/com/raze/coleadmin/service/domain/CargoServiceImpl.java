package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Cargo;
import com.raze.coleadmin.repository.domain.CargoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

	@Autowired
    CargoRepository cargoRepository;
	
	Date date = new Date();

	public long countAllCargoes() {
        return cargoRepository.count();
    }

	public void deleteCargo(Cargo cargo) {
        cargoRepository.delete(cargo);
    }

	public Cargo findCargo(Long id) {
        return cargoRepository.findOne(id);
    }

	public List<Cargo> findAllCargoes() {
        return cargoRepository.findAll();
    }

	public List<Cargo> findCargoEntries(int firstResult, int maxResults) {
        return cargoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCargo(Cargo cargo) {
		cargo.setUsuario(Authenticated.getUsuario());
		cargo.setFechaCreacion(date);
		cargo.setActivo(true);
        cargoRepository.save(cargo);
    }

	public Cargo updateCargo(Cargo cargo) {
		cargo.setUsuario(Authenticated.getUsuario());
		cargo.setFechaModificacion(date);
		cargo.setActivo(true);
        return cargoRepository.save(cargo);
    }

	public Cargo logicalDeleteCargo(Cargo cargo) {
		cargo.setUsuario(Authenticated.getUsuario());
		cargo.setFechaModificacion(date);
		cargo.setActivo(false);
        return cargoRepository.save(cargo);
    }
	
}
