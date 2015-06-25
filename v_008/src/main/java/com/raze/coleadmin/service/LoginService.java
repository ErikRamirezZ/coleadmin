package com.raze.coleadmin.service;
import com.raze.coleadmin.domain.Login;
import java.util.List;

public interface LoginService {

	public abstract long countAllLogins();


	public abstract void deleteLogin(Login login);


	public abstract Login findLogin(Long id);


	public abstract List<Login> findAllLogins();


	public abstract List<Login> findLoginEntries(int firstResult, int maxResults);


	public abstract void saveLogin(Login login);


	public abstract Login updateLogin(Login login);

}
