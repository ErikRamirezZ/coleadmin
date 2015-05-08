package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.repository.domain.CuentaRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CuentaServiceImpl implements CuentaService {

	@Autowired
    CuentaRepository cuentaRepository;
	
	Date date = new Date();

	public long countAllCuentas() {
        return cuentaRepository.count();
    }

	public void deleteCuenta(Cuenta cuenta) {
        cuentaRepository.delete(cuenta);
    }

	public Cuenta findCuenta(Long id) {
        return cuentaRepository.findOne(id);
    }

	public List<Cuenta> findAllCuentas() {
        return cuentaRepository.findAll();
    }

	public List<Cuenta> findCuentaEntries(int firstResult, int maxResults) {
        return cuentaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveCuenta(Cuenta cuenta) {
		cuenta.setUsuario(Authenticated.getUsuario());
		cuenta.setFechaCreacion(date);
		cuenta.setActivo(true);
        cuentaRepository.save(cuenta);
    }

	public Cuenta updateCuenta(Cuenta cuenta) {
		cuenta.setUsuario(Authenticated.getUsuario());
		cuenta.setFechaModificacion(date);
		cuenta.setActivo(true);
        return cuentaRepository.save(cuenta);
    }
	
	public Cuenta logicalDeleteCuenta(Cuenta cuenta) {
		cuenta.setUsuario(Authenticated.getUsuario());
		cuenta.setFechaModificacion(date);
		cuenta.setActivo(false);
        return cuentaRepository.save(cuenta);
    }
		
}
