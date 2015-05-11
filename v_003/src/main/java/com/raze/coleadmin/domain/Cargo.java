package com.raze.coleadmin.domain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;

import com.raze.coleadmin.catalog.TipoConcepto;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;

@Entity
public class Cargo {

    /**
     */
    @ManyToOne
    private Cuenta cuenta;

    /**
     */
    @Enumerated
    private TipoConcepto tipoConcepto;

    /**
     */
    @OneToMany
    private List<Concepto> concepto = new ArrayList<Concepto>();

    /**
     */
    private Double subtotal;

    /**
     */
    private Double total;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaCargo;

    /**
     */
    @ManyToOne
    private Pago pago;

    /**
     */
    private Boolean fuePagoOportuno;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaPago;

    /**
     */
    @ManyToOne(cascade = {CascadeType.ALL})
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Cargo fromJsonToCargo(String json) {
        return new JSONDeserializer<Cargo>()
        .use(null, Cargo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Cargo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Cargo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Cargo> fromJsonArrayToCargoes(String json) {
        return new JSONDeserializer<List<Cargo>>()
        .use("values", Cargo.class).deserialize(json);
    }

	public Cuenta getCuenta() {
        return this.cuenta;
    }

	public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

	public TipoConcepto getTipoConcepto() {
        return this.tipoConcepto;
    }

	public void setTipoConcepto(TipoConcepto tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

	public List<Concepto> getConcepto() {
        return this.concepto;
    }

	public void setConcepto(List<Concepto> concepto) {
        this.concepto = concepto;
    }

	public Double getSubtotal() {
        return this.subtotal;
    }

	public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

	public Double getTotal() {
        return this.total;
    }

	public void setTotal(Double total) {
        this.total = total;
    }

	public Date getFechaCargo() {
        return this.fechaCargo;
    }

	public void setFechaCargo(Date fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

	public Pago getPago() {
        return this.pago;
    }

	public void setPago(Pago pago) {
        this.pago = pago;
    }

	public Boolean getFuePagoOportuno() {
        return this.fuePagoOportuno;
    }

	public void setFuePagoOportuno(Boolean fuePagoOportuno) {
        this.fuePagoOportuno = fuePagoOportuno;
    }

	public Date getFechaPago() {
        return this.fechaPago;
    }

	public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
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
}
