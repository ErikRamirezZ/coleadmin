package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.ManyToOne;

@Entity
public class Padre extends Usuario {

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
    @NotNull
    @ManyToOne
    private Plantel plantel;

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

	public Plantel getPlantel() {
        return this.plantel;
    }

	public void setPlantel(Plantel plantel) {
        this.plantel = plantel;
    }
}
