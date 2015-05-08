package com.raze.coleadmin.service.domain;

import com.raze.coleadmin.domain.Pago;
import com.raze.coleadmin.repository.domain.PagoRepository;
import com.raze.coleadmin.util.Authenticated;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PagoServiceImpl implements PagoService {

	@Autowired
    PagoRepository pagoRepository;
	
	private Date date = new Date();

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
		pago.setUsuario(Authenticated.getUsuario());
		pago.setFechaCreacion(date);
		pago.setActivo(true);
        pagoRepository.save(pago);
    }

	public Pago updatePago(Pago pago) {
		pago.setUsuario(Authenticated.getUsuario());
		pago.setFechaModificacion(date);
		pago.setActivo(true);
        return pagoRepository.save(pago);
    }

	public Pago logicalDeletePago(Pago pago) {
		pago.setUsuario(Authenticated.getUsuario());
		pago.setFechaModificacion(date);
		pago.setActivo(false);
        return pagoRepository.save(pago);
    }
	
}
