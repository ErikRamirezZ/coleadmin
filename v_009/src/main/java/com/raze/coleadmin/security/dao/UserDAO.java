package com.raze.coleadmin.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String  findUserByUsername(String username) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT dtype AS typeusuario FROM usuario ");
		sql.append("WHERE correoe = ? ");
		return jdbcTemplate.queryForObject(sql.toString(), String.class,
				new Object[] { username });
	}

}
