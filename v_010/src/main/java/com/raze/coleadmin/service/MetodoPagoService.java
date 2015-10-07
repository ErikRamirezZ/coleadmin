package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.MetodoPago;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.MetodoPago.class })
public interface MetodoPagoService {

	public abstract long countAllMetodoPagoes();


	public abstract void deleteMetodoPago(MetodoPago metodoPago);


	public abstract MetodoPago findMetodoPago(Long id);


	public abstract List<MetodoPago> findAllMetodoPagoes();


	public abstract List<MetodoPago> findMetodoPagoEntries(int firstResult, int maxResults);


	public abstract void saveMetodoPago(MetodoPago metodoPago);


	public abstract MetodoPago updateMetodoPago(MetodoPago metodoPago);

}
