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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ConfiguracionCurso {

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Curso> curso = new HashSet<Curso>();

    /**
     */
    private Double cuotaMensual;

    /**
     */
    private Double cuotaInscripcion;

    /**
     */
    private Integer diaCorte;

    /**
     */
    private Integer diaPago;

    /**
     */
    private Integer numeroDiasParaPagar;

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

	public static ConfiguracionCurso fromJsonToConfiguracionCurso(String json) {
        return new JSONDeserializer<ConfiguracionCurso>()
        .use(null, ConfiguracionCurso.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ConfiguracionCurso> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ConfiguracionCurso> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ConfiguracionCurso> fromJsonArrayToConfiguracionCursoes(String json) {
        return new JSONDeserializer<List<ConfiguracionCurso>>()
        .use("values", ConfiguracionCurso.class).deserialize(json);
    }

	public Set<Curso> getCurso() {
        return this.curso;
    }

	public void setCurso(Set<Curso> curso) {
        this.curso = curso;
    }

	public Double getCuotaMensual() {
        return this.cuotaMensual;
    }

	public void setCuotaMensual(Double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

	public Double getCuotaInscripcion() {
        return this.cuotaInscripcion;
    }

	public void setCuotaInscripcion(Double cuotaInscripcion) {
        this.cuotaInscripcion = cuotaInscripcion;
    }

	public Integer getDiaCorte() {
        return this.diaCorte;
    }

	public void setDiaCorte(Integer diaCorte) {
        this.diaCorte = diaCorte;
    }

	public Integer getDiaPago() {
        return this.diaPago;
    }

	public void setDiaPago(Integer diaPago) {
        this.diaPago = diaPago;
    }

	public Integer getNumeroDiasParaPagar() {
        return this.numeroDiasParaPagar;
    }

	public void setNumeroDiasParaPagar(Integer numeroDiasParaPagar) {
        this.numeroDiasParaPagar = numeroDiasParaPagar;
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
