package com.raze.coleadmin.service.domain;
import com.raze.coleadmin.domain.Pago;
import java.util.List;

public interface PagoService {

	public abstract long countAllPagoes();


	public abstract void deletePago(Pago pago);


	public abstract Pago findPago(Long id);


	public abstract List<Pago> findAllPagoes();


	public abstract List<Pago> findPagoEntries(int firstResult, int maxResults);


	public abstract void savePago(Pago pago);


	public abstract Pago updatePago(Pago pago);


	public abstract Pago logicalDeletePago(Pago pago);

}
