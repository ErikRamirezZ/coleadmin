package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

import com.raze.coleadmin.catalog.Rol;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Padre extends Usuario implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     */
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Alumno> hijos = new HashSet<Alumno>();

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Rol> roles = new HashSet<Rol>();

	public Set<Alumno> getHijos() {
        return this.hijos;
    }

	public void setHijos(Set<Alumno> hijos) {
        this.hijos = hijos;
    }

	public Escuela getEscuela() {
        return this.escuela;
    }

	public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

	public Set<Rol> getRoles() {
        return this.roles;
    }

	public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Padre fromJsonToPadre(String json) {
        return new JSONDeserializer<Padre>()
        .use(null, Padre.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Padre> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Padre> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Padre> fromJsonArrayToPadres(String json) {
        return new JSONDeserializer<List<Padre>>()
        .use("values", Padre.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getUsername() {
		return super.getCorreoE();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
