package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.ManyToOne;
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
import javax.persistence.Version;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Plantel {

    /**
     */
    @ManyToOne
    private Escuela escuelas;

    /**
     */
    private String nombre;

    /**
     */
    private String calle;

    /**
     */
    private String numero;

    /**
     */
    private String codigoPostal;

    /**
     */
    private String correoE;

    /**
     */
    private String telefono1;

    /**
     */
    private String telefono2;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Plantel fromJsonToPlantel(String json) {
        return new JSONDeserializer<Plantel>()
        .use(null, Plantel.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Plantel> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Plantel> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Plantel> fromJsonArrayToPlantels(String json) {
        return new JSONDeserializer<List<Plantel>>()
        .use("values", Plantel.class).deserialize(json);
    }

	public Escuela getEscuelas() {
        return this.escuelas;
    }

	public void setEscuelas(Escuela escuelas) {
        this.escuelas = escuelas;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getCalle() {
        return this.calle;
    }

	public void setCalle(String calle) {
        this.calle = calle;
    }

	public String getNumero() {
        return this.numero;
    }

	public void setNumero(String numero) {
        this.numero = numero;
    }

	public String getCodigoPostal() {
        return this.codigoPostal;
    }

	public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public String getTelefono1() {
        return this.telefono1;
    }

	public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

	public String getTelefono2() {
        return this.telefono2;
    }

	public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
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
