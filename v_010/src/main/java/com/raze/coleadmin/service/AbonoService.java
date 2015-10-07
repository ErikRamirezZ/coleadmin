package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Abono;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.Abono.class })
public interface AbonoService {

	public abstract long countAllAbonoes();


	public abstract void deleteAbono(Abono abono);


	public abstract Abono findAbono(Long id);


	public abstract List<Abono> findAllAbonoes();


	public abstract List<Abono> findAbonoEntries(int firstResult, int maxResults);


	public abstract void saveAbono(Abono abono);


	public abstract Abono updateAbono(Abono abono);

}
