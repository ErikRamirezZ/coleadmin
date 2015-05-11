package com.raze.coleadmin.domain;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.raze.coleadmin.catalog.SeRepite;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Repeticiones {

    /**
     */
    @ManyToOne
    private Cargo cargo;

    /**
     */
    @Enumerated
    private SeRepite seReqpite;

    /**
     */
    private Integer numeroVeces;

    /**
     */
    @ManyToOne
    private Usuario usuario;

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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Cargo getCargo() {
        return this.cargo;
    }

	public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

	public SeRepite getSeReqpite() {
        return this.seReqpite;
    }

	public void setSeReqpite(SeRepite seReqpite) {
        this.seReqpite = seReqpite;
    }

	public Integer getNumeroVeces() {
        return this.numeroVeces;
    }

	public void setNumeroVeces(Integer numeroVeces) {
        this.numeroVeces = numeroVeces;
    }

	public Usuario getUsuario() {
        return this.usuario;
    }

	public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Repeticiones fromJsonToRepeticiones(String json) {
        return new JSONDeserializer<Repeticiones>()
        .use(null, Repeticiones.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Repeticiones> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Repeticiones> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Repeticiones> fromJsonArrayToRepeticioneses(String json) {
        return new JSONDeserializer<List<Repeticiones>>()
        .use("values", Repeticiones.class).deserialize(json);
    }
}
