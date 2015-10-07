package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.Contacto;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import com.raze.coleadmin.catalog.Rol;
import com.raze.coleadmin.catalog.Permiso;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Padre extends Usuario {

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

    /**
     */
    @ManyToOne
    private Domicilio domicilio;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Contacto> contactos = new HashSet<Contacto>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Rol> roles = new HashSet<Rol>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Permiso> permisos = new HashSet<Permiso>();

	public Escuela getEscuela() {
        return this.escuela;
    }

	public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

	public Domicilio getDomicilio() {
        return this.domicilio;
    }

	public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

	public Set<Contacto> getContactos() {
        return this.contactos;
    }

	public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

	public Set<Rol> getRoles() {
        return this.roles;
    }

	public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

	public Set<Permiso> getPermisos() {
        return this.permisos;
    }

	public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
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
}
