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
public class Alumno extends Usuario {

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

    /**
     */
    private String curp;

    /**
     */
    private String tipoSangre;

    /**
     */
    private String talla;

    /**
     */
    private String peso;

    /**
     */
    private String alergias;

    /**
     */
    private String folio;

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

	public String getCurp() {
        return this.curp;
    }

	public void setCurp(String curp) {
        this.curp = curp;
    }

	public String getTipoSangre() {
        return this.tipoSangre;
    }

	public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

	public String getTalla() {
        return this.talla;
    }

	public void setTalla(String talla) {
        this.talla = talla;
    }

	public String getPeso() {
        return this.peso;
    }

	public void setPeso(String peso) {
        this.peso = peso;
    }

	public String getAlergias() {
        return this.alergias;
    }

	public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

	public String getFolio() {
        return this.folio;
    }

	public void setFolio(String folio) {
        this.folio = folio;
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Alumno fromJsonToAlumno(String json) {
        return new JSONDeserializer<Alumno>()
        .use(null, Alumno.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Alumno> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Alumno> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Alumno> fromJsonArrayToAlumnoes(String json) {
        return new JSONDeserializer<List<Alumno>>()
        .use("values", Alumno.class).deserialize(json);
    }
}
