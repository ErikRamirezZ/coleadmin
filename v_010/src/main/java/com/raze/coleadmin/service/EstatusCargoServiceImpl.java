package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.EstatusCargo;
import com.raze.coleadmin.repository.EstatusCargoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EstatusCargoServiceImpl implements EstatusCargoService {

	@Autowired
    EstatusCargoRepository estatusCargoRepository;

	public long countAllEstatusCargoes() {
        return estatusCargoRepository.count();
    }

	public void deleteEstatusCargo(EstatusCargo estatusCargo) {
        estatusCargoRepository.delete(estatusCargo);
    }

	public EstatusCargo findEstatusCargo(Long id) {
        return estatusCargoRepository.findOne(id);
    }

	public List<EstatusCargo> findAllEstatusCargoes() {
        return estatusCargoRepository.findAll();
    }

	public List<EstatusCargo> findEstatusCargoEntries(int firstResult, int maxResults) {
        return estatusCargoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveEstatusCargo(EstatusCargo estatusCargo) {
        estatusCargoRepository.save(estatusCargo);
    }

	public EstatusCargo updateEstatusCargo(EstatusCargo estatusCargo) {
        return estatusCargoRepository.save(estatusCargo);
    }
}
