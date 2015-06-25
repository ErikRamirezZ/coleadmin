package com.raze.coleadmin.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.raze.coleadmin.domain.Login;

@Repository
public interface LoginRepository extends JpaSpecificationExecutor<Login>, JpaRepository<Login, Long> {
	
	public Login findByUsername(String username);
	
}
