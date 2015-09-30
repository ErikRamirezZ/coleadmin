package com.raze.coleadmin.repository;
import com.raze.coleadmin.catalog.Contacto;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Contacto.class)
public interface ContactoRepository {
}
