package com.raze.coleadmin.service;

import com.raze.coleadmin.catalog.MetodoPago;
import com.raze.coleadmin.repository.MetodoPagoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MetodoPagoServiceImpl implements MetodoPagoService {

	@Autowired
    MetodoPagoRepository metodoPagoRepository;

	public long countAllMetodoPagoes() {
        return metodoPagoRepository.count();
    }

	public void deleteMetodoPago(MetodoPago metodoPago) {
        metodoPagoRepository.delete(metodoPago);
    }

	public MetodoPago findMetodoPago(Long id) {
        return metodoPagoRepository.findOne(id);
    }

	public List<MetodoPago> findAllMetodoPagoes() {
        return metodoPagoRepository.findAll();
    }

	public List<MetodoPago> findMetodoPagoEntries(int firstResult, int maxResults) {
        return metodoPagoRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveMetodoPago(MetodoPago metodoPago) {
        metodoPagoRepository.save(metodoPago);
    }

	public MetodoPago updateMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }
}
