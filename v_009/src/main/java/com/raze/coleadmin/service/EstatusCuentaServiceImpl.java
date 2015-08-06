package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.EstatusCuenta;
import com.raze.coleadmin.repository.EstatusCuentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstatusCuentaServiceImpl implements EstatusCuentaService {

	@Autowired
    EstatusCuentaRepository estatusCuentaRepository;

	public long countAllEstatusCuentas() {
        return estatusCuentaRepository.count();
    }

	public void deleteEstatusCuenta(EstatusCuenta estatusCuenta) {
        estatusCuentaRepository.delete(estatusCuenta);
    }

	public EstatusCuenta findEstatusCuenta(Long id) {
        return estatusCuentaRepository.findOne(id);
    }

	public List<EstatusCuenta> findAllEstatusCuentas() {
        return estatusCuentaRepository.findAll();
    }

	public List<EstatusCuenta> findEstatusCuentaEntries(int firstResult, int maxResults) {
        return estatusCuentaRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEstatusCuenta(EstatusCuenta estatusCuenta) {
        estatusCuentaRepository.save(estatusCuenta);
    }

	public EstatusCuenta updateEstatusCuenta(EstatusCuenta estatusCuenta) {
        return estatusCuentaRepository.save(estatusCuenta);
    }
}
