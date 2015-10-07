package com.raze.coleadmin.service;
import com.raze.coleadmin.catalog.Categoria;
import java.util.List;
import org.springframework.roo.addon.layers.service.RooService;

@RooService(domainTypes = { com.raze.coleadmin.catalog.Categoria.class })
public interface CategoriaService {

	public abstract long countAllCategorias();


	public abstract void deleteCategoria(Categoria categoria);


	public abstract Categoria findCategoria(Long id);


	public abstract List<Categoria> findAllCategorias();


	public abstract List<Categoria> findCategoriaEntries(int firstResult, int maxResults);


	public abstract void saveCategoria(Categoria categoria);


	public abstract Categoria updateCategoria(Categoria categoria);

}
