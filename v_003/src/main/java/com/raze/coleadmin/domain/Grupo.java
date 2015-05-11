package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

import javax.persistence.ManyToOne;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Grupo {

    /**
     */
    @ManyToOne
    private Curso curso;

    /**
     */
    @ManyToOne
    private Usuario docente;

    /**
     */
    private String salon;

    /**
     */
    private String nombreGrupo;

    /**
     */
    private String descripcion;

    /**
     */
    @ManyToOne(cascade = CascadeType.ALL)
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

	public static Grupo fromJsonToGrupo(String json) {
        return new JSONDeserializer<Grupo>()
        .use(null, Grupo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Grupo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Grupo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Grupo> fromJsonArrayToGrupoes(String json) {
        return new JSONDeserializer<List<Grupo>>()
        .use("values", Grupo.class).deserialize(json);
    }

	public Curso getCurso() {
        return this.curso;
    }

	public void setCurso(Curso curso) {
        this.curso = curso;
    }

	public Usuario getDocente() {
        return this.docente;
    }

	public void setDocente(Usuario docente) {
        this.docente = docente;
    }

	public String getSalon() {
        return this.salon;
    }

	public void setSalon(String salon) {
        this.salon = salon;
    }

	public String getNombreGrupo() {
        return this.nombreGrupo;
    }

	public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

	public String getDescripcion() {
        return this.descripcion;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
