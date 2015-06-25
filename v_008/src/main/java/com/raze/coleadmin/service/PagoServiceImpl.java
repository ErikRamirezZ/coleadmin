package com.raze.coleadmin.service;

import com.raze.coleadmin.domain.Pago;
import com.raze.coleadmin.repository.PagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagoServiceImpl implements PagoService {

	@Autowired
    PagoRepository pagoRepository;

	public long countAllPagoes() {
        return pagoRepository.count();
    }

	public void deletePago(Pago pago) {
        pagoRepository.delete(pago);
    }

	public Pago findPago(Long id) {
        return pagoRepository.findOne(id);
    }

	public List<Pago> findAllPagoes() {
        return pagoRepository.findAll();
    }

	public List<Pago> findPagoEntries(int firstResult, int maxResults) {
        return pagoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void savePago(Pago pago) {
        pagoRepository.save(pago);
    }

	public Pago updatePago(Pago pago) {
        return pagoRepository.save(pago);
    }
}
