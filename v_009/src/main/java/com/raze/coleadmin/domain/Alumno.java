package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import com.raze.coleadmin.catalog.Rol;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class Alumno extends Usuario {

    /**
     */
    @NotNull
    private String curp;

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

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
    @Size(max = 250)
    private String observaciones;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Rol> roles = new HashSet<Rol>();

	public String getCurp() {
        return this.curp;
    }

	public void setCurp(String curp) {
        this.curp = curp;
    }

	public Escuela getEscuela() {
        return this.escuela;
    }

	public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
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

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

	public Set<Rol> getRoles() {
        return this.roles;
    }

	public void setRoles(Set<Rol> roles) {
        this.roles = roles;
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
