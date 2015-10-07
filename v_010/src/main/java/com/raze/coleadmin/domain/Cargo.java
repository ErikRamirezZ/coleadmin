package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.catalog.EstatusCargo;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Cargo {

    /**
     */
    @NotNull
    @ManyToOne
    private Alumno alumno;

    /**
     */
    @NotNull
    @ManyToOne
    private Concepto concepto;

    /**
     */
    @NotNull
    private Double cantidad;

    /**
     */
    @NotNull
    private Double subtotal;

    /**
     */
    private Double descuentoPorcentaje;

    /**
     */
    private Double descuentoPesos;

    /**
     */
    @NotNull
    private Double total;

    /**
     */
    @ManyToOne
    private EstatusCargo estatusCargo;

    /**
     */
    @ManyToOne
    private Usuario usuarioCrea;

    /**
     */
    @ManyToOne
    private Usuario usuarioModifica;

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

	public Alumno getAlumno() {
        return this.alumno;
    }

	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

	public Concepto getConcepto() {
        return this.concepto;
    }

	public void setConcepto(Concepto concepto) {
        this.concepto = concepto;
    }

	public Double getCantidad() {
        return this.cantidad;
    }

	public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

	public Double getSubtotal() {
        return this.subtotal;
    }

	public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

	public Double getDescuentoPorcentaje() {
        return this.descuentoPorcentaje;
    }

	public void setDescuentoPorcentaje(Double descuentoPorcentaje) {
        this.descuentoPorcentaje = descuentoPorcentaje;
    }

	public Double getDescuentoPesos() {
        return this.descuentoPesos;
    }

	public void setDescuentoPesos(Double descuentoPesos) {
        this.descuentoPesos = descuentoPesos;
    }

	public Double getTotal() {
        return this.total;
    }

	public void setTotal(Double total) {
        this.total = total;
    }

	public EstatusCargo getEstatusCargo() {
        return this.estatusCargo;
    }

	public void setEstatusCargo(EstatusCargo estatusCargo) {
        this.estatusCargo = estatusCargo;
    }

	public Usuario getUsuarioCrea() {
        return this.usuarioCrea;
    }

	public void setUsuarioCrea(Usuario usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

	public Usuario getUsuarioModifica() {
        return this.usuarioModifica;
    }

	public void setUsuarioModifica(Usuario usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
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

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
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
}
