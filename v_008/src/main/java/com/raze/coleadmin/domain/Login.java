package com.raze.coleadmin.domain;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Login implements UserDetails {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
	@Transient
	private Usuario usuario;
	
	/**
     */
	@NotNull
	private String username;

	/**
     */
	@NotNull
	private String password;

	/**
     */
	private Long idUsuario;

	/**
     */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date fechaCreacion;

	/**
     */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date fechaModificacion;

	/**
     */
	private Boolean activo;

	/**
     */
    @OneToMany
	private List<Rol> roles;
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String toJson() {
		return new JSONSerializer().exclude("*.class").deepSerialize(this);
	}

	public String toJson(String[] fields) {
		return new JSONSerializer().include(fields).exclude("*.class")
				.deepSerialize(this);
	}

	public static Login fromJsonToLogin(String json) {
		return new JSONDeserializer<Login>().use(null, Login.class)
				.deserialize(json);
	}

	public static String toJsonArray(Collection<Login> collection) {
		return new JSONSerializer().exclude("*.class")
				.deepSerialize(collection);
	}

	public static String toJsonArray(Collection<Login> collection,
			String[] fields) {
		return new JSONSerializer().include(fields).exclude("*.class")
				.deepSerialize(collection);
	}

	public static Collection<Login> fromJsonArrayToLogins(String json) {
		return new JSONDeserializer<List<Login>>().use("values", Login.class)
				.deserialize(json);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Version
	@Column(name = "version")
	private Integer version;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		return ReflectionToStringBuilder.toString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
