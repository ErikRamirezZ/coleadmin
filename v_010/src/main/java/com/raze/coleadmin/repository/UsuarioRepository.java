package com.raze.coleadmin.repository;
import com.raze.coleadmin.domain.Usuario;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Usuario.class)
public interface UsuarioRepository {
}
