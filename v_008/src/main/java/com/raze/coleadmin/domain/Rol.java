package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import java.util.Collection;
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
import javax.persistence.Version;

@Entity
public class Rol implements GrantedAuthority {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
    private String nombre;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Permiso> permisos = new HashSet<Permiso>();

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

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public Set<Permiso> getPermisos() {
        return this.permisos;
    }

	public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }

	@Override
	public String getAuthority() {
		return nombre;
	}
}
