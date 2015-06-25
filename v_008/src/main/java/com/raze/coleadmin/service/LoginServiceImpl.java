package com.raze.coleadmin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raze.coleadmin.domain.Login;
import com.raze.coleadmin.repository.LoginRepository;

@Service
@Transactional
public class LoginServiceImpl implements LoginService, UserDetailsService {

	private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Autowired
    LoginRepository loginRepository;

	public long countAllLogins() {
        return loginRepository.count();
    }

	public void deleteLogin(Login login) {
        loginRepository.delete(login);
    }

	public Login findLogin(Long id) {
        return loginRepository.findOne(id);
    }

	public List<Login> findAllLogins() {
        return loginRepository.findAll();
    }

	public List<Login> findLoginEntries(int firstResult, int maxResults) {
        return loginRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults)).getContent();
    }

	public void saveLogin(Login login) {
        loginRepository.save(login);
    }

	public Login updateLogin(Login login) {
        return loginRepository.save(login);
    }

	@Override
	public Login loadUserByUsername(String username)
			throws UsernameNotFoundException {
		log.info("Ya estoy en el servicio y voy al repository");
		Login login = loginRepository.findByUsername(username);
		return login;
	}
}
