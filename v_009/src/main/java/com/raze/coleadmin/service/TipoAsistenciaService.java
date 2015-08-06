package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.TipoAsistencia;
import java.util.List;

public interface TipoAsistenciaService {

	public abstract long countAllTipoAsistencias();


	public abstract void deleteTipoAsistencia(TipoAsistencia tipoAsistencia);


	public abstract TipoAsistencia findTipoAsistencia(Long id);


	public abstract List<TipoAsistencia> findAllTipoAsistencias();


	public abstract List<TipoAsistencia> findTipoAsistenciaEntries(int firstResult, int maxResults);


	public abstract void saveTipoAsistencia(TipoAsistencia tipoAsistencia);


	public abstract TipoAsistencia updateTipoAsistencia(TipoAsistencia tipoAsistencia);

}
