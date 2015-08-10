package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.EstatusCuenta;
import java.util.List;

public interface EstatusCuentaService {

	public abstract long countAllEstatusCuentas();


	public abstract void deleteEstatusCuenta(EstatusCuenta estatusCuenta);


	public abstract EstatusCuenta findEstatusCuenta(Long id);


	public abstract List<EstatusCuenta> findAllEstatusCuentas();


	public abstract List<EstatusCuenta> findEstatusCuentaEntries(int firstResult, int maxResults);


	public abstract void saveEstatusCuenta(EstatusCuenta estatusCuenta);


	public abstract EstatusCuenta updateEstatusCuenta(EstatusCuenta estatusCuenta);

}
