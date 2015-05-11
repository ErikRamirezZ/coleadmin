package com.raze.coleadmin.domain;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Cuenta {

    /**
     */
    @ManyToOne
    private Escuela escuela;

    /**
     */
    @ManyToOne
    private Plantel plantel;

    /**
     */
    @ManyToOne
    private CicloEscolar cicloEscolar;

    /**
     */
    @ManyToOne
    private Curso curso;

    /**
     */
    @ManyToOne
    private Usuario padreTutor;

    /**
     */
    @ManyToOne
    private Usuario alumno;

    /**
     */
    private Integer beca;

    /**
     */
    private Boolean enviarRecordatorios;

    /**
     */
    private Integer estatus;

    /**
     */
    private Double saldoTotal;

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

	public CicloEscolar getCicloEscolar() {
        return this.cicloEscolar;
    }

	public void setCicloEscolar(CicloEscolar cicloEscolar) {
        this.cicloEscolar = cicloEscolar;
    }

	public Curso getCurso() {
        return this.curso;
    }

	public void setCurso(Curso curso) {
        this.curso = curso;
    }

	public Usuario getPadreTutor() {
        return this.padreTutor;
    }

	public void setPadreTutor(Usuario padreTutor) {
        this.padreTutor = padreTutor;
    }

	public Usuario getAlumno() {
        return this.alumno;
    }

	public void setAlumno(Usuario alumno) {
        this.alumno = alumno;
    }

	public Integer getBeca() {
        return this.beca;
    }

	public void setBeca(Integer beca) {
        this.beca = beca;
    }

	public Boolean getEnviarRecordatorios() {
        return this.enviarRecordatorios;
    }

	public void setEnviarRecordatorios(Boolean enviarRecordatorios) {
        this.enviarRecordatorios = enviarRecordatorios;
    }

	public Integer getEstatus() {
        return this.estatus;
    }

	public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

	public Double getSaldoTotal() {
        return this.saldoTotal;
    }

	public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Cuenta fromJsonToCuenta(String json) {
        return new JSONDeserializer<Cuenta>()
        .use(null, Cuenta.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Cuenta> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Cuenta> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Cuenta> fromJsonArrayToCuentas(String json) {
        return new JSONDeserializer<List<Cuenta>>()
        .use("values", Cuenta.class).deserialize(json);
    }
}
