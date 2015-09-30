package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Categoria;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Categoria.class)
public interface CategoriaRepository {
}
