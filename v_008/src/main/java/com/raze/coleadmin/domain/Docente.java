package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Docente extends Usuario {

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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Docente fromJsonToDocente(String json) {
        return new JSONDeserializer<Docente>()
        .use(null, Docente.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Docente> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Docente> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Docente> fromJsonArrayToDocentes(String json) {
        return new JSONDeserializer<List<Docente>>()
        .use("values", Docente.class).deserialize(json);
    }
}
