package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Cuenta;
import com.raze.coleadmin.repository.CuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CuentaServiceImpl implements CuentaService {

	@Autowired
    CuentaRepository cuentaRepository;

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
        cuentaRepository.save(cuenta);
    }

	public Cuenta updateCuenta(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }
}
