package com.raze.coleadmin.service.domain;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Usuario;
import com.raze.coleadmin.repository.domain.UsuarioRepository;
import com.raze.coleadmin.util.Authenticated;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

	@Autowired
    UsuarioRepository usuarioRepository;
	
	private Date date = new Date();

	public long countAllUsuarios() {
        return usuarioRepository.count();
    }

	public void deleteUsuario(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

	public Usuario findUsuario(Long id) {
        return usuarioRepository.findOne(id);
    }

	public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

	public List<Usuario> findUsuarioEntries(int firstResult, int maxResults) {
        return usuarioRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveUsuario(Usuario usuario) {
		usuario.setUsuario(Authenticated.getUsuario());
		usuario.setFechaCreacion(date);
		usuario.setActivo(true);
        usuarioRepository.save(usuario);
    }

	public Usuario updateUsuario(Usuario usuario) {
		usuario.setUsuario(Authenticated.getUsuario());
		usuario.setFechaModificacion(date);
		usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

	public Usuario logicalDeleteUsuario(Usuario usuario) {
		usuario.setUsuario(Authenticated.getUsuario());
		usuario.setFechaModificacion(date);
		usuario.setActivo(false);
        return usuarioRepository.save(usuario);
    }

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return usuarioRepository.findByUsername(username);
	}
}
