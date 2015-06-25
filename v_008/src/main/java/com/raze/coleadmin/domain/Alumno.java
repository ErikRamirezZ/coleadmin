package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Alumno extends Usuario {

    /**
     */
    @NotNull
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
    @Size(max = 250)
    private String observaciones;

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

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
