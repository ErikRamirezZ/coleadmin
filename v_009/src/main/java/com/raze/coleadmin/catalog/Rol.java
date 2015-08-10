package com.raze.coleadmin.catalog;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Rol implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
    @NotNull
    private String nombreRol;

    /**
     */
    private String descripcion;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Permiso> permisos = new HashSet<Permiso>();

    /**
     */
    private Long usuarioCrea;

    /**
     */
    private Long usuarioModifica;

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

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }

	public String getNombreRol() {
        return this.nombreRol;
    }

	public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

	public String getDescripcion() {
        return this.descripcion;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

	public Set<Permiso> getPermisos() {
        return this.permisos;
    }

	public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

	public Long getUsuarioCrea() {
        return this.usuarioCrea;
    }

	public void setUsuarioCrea(Long usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

	public Long getUsuarioModifica() {
        return this.usuarioModifica;
    }

	public void setUsuarioModifica(Long usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

	public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

	public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

	public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

	public Boolean getActivo() {
        return this.activo;
    }

	public void setActivo(Boolean activo) {
        this.activo = activo;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Rol fromJsonToRol(String json) {
        return new JSONDeserializer<Rol>()
        .use(null, Rol.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Rol> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Rol> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Rol> fromJsonArrayToRols(String json) {
        return new JSONDeserializer<List<Rol>>()
        .use("values", Rol.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public String getAuthority() {
		return "ROLE_" + nombreRol;
	}
}
