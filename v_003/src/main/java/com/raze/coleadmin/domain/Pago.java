package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import com.raze.coleadmin.catalog.MetodoPago;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.Enumerated;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pago {

    /**
     */
    @ManyToOne
    private Cuenta cuenta;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Cargo> cargo = new HashSet<Cargo>();

    /**
     */
    @Enumerated
    private MetodoPago metodoPago;

    /**
     */
    private Double monto;

    /**
     */
    private Integer descuento;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaPago;

    /**
     */
    private String observaciones;

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

	public Cuenta getCuenta() {
        return this.cuenta;
    }

	public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

	public Set<Cargo> getCargo() {
        return this.cargo;
    }

	public void setCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
    }

	public MetodoPago getMetodoPago() {
        return this.metodoPago;
    }

	public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

	public Double getMonto() {
        return this.monto;
    }

	public void setMonto(Double monto) {
        this.monto = monto;
    }

	public Integer getDescuento() {
        return this.descuento;
    }

	public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

	public Date getFechaPago() {
        return this.fechaPago;
    }

	public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

	public String getObservaciones() {
        return this.observaciones;
    }

	public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

	public static Pago fromJsonToPago(String json) {
        return new JSONDeserializer<Pago>()
        .use(null, Pago.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Pago> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Pago> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Pago> fromJsonArrayToPagoes(String json) {
        return new JSONDeserializer<List<Pago>>()
        .use("values", Pago.class).deserialize(json);
    }
}
