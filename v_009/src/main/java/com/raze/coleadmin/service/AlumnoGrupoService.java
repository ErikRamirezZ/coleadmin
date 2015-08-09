package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.AlumnoGrupo;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.domain.AlumnoGrupo.class })
public interface AlumnoGrupoService {

	public abstract long countAllAlumnoGrupoes();


	public abstract void deleteAlumnoGrupo(AlumnoGrupo alumnoGrupo);


	public abstract AlumnoGrupo findAlumnoGrupo(Long id);


	public abstract List<AlumnoGrupo> findAllAlumnoGrupoes();


	public abstract List<AlumnoGrupo> findAlumnoGrupoEntries(int firstResult, int maxResults);


	public abstract void saveAlumnoGrupo(AlumnoGrupo alumnoGrupo);


	public abstract AlumnoGrupo updateAlumnoGrupo(AlumnoGrupo alumnoGrupo);

}
