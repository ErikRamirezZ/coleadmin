package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
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
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class ConfiguracionCurso {

    /**
     */
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Curso> curso = new HashSet<Curso>();

    /**
     */
    @NotNull
    private Double cuotaInscripcion;

    /**
     */
    @NotNull
    private Double cuotaMensual;

    /**
     */
    private Double seguro;

    /**
     */
    private Double cuotaPadres;

    /**
     */
    private Double credencial;

    /**
     */
    private Double otro;

    /**
     */
    private Integer diaCorte;

    /**
     */
    private Integer numeroDiasParaPagar;

    /**
     */
    private Long usuarioCrea;

    /**
     */
    private Long usuarioModifica;

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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	public Set<Curso> getCurso() {
        return this.curso;
    }

	public void setCurso(Set<Curso> curso) {
        this.curso = curso;
    }

	public Double getCuotaInscripcion() {
        return this.cuotaInscripcion;
    }

	public void setCuotaInscripcion(Double cuotaInscripcion) {
        this.cuotaInscripcion = cuotaInscripcion;
    }

	public Double getCuotaMensual() {
        return this.cuotaMensual;
    }

	public void setCuotaMensual(Double cuotaMensual) {
        this.cuotaMensual = cuotaMensual;
    }

	public Double getSeguro() {
        return this.seguro;
    }

	public void setSeguro(Double seguro) {
        this.seguro = seguro;
    }

	public Double getCuotaPadres() {
        return this.cuotaPadres;
    }

	public void setCuotaPadres(Double cuotaPadres) {
        this.cuotaPadres = cuotaPadres;
    }

	public Double getCredencial() {
        return this.credencial;
    }

	public void setCredencial(Double credencial) {
        this.credencial = credencial;
    }

	public Double getOtro() {
        return this.otro;
    }

	public void setOtro(Double otro) {
        this.otro = otro;
    }

	public Integer getDiaCorte() {
        return this.diaCorte;
    }

	public void setDiaCorte(Integer diaCorte) {
        this.diaCorte = diaCorte;
    }

	public Integer getNumeroDiasParaPagar() {
        return this.numeroDiasParaPagar;
    }

	public void setNumeroDiasParaPagar(Integer numeroDiasParaPagar) {
        this.numeroDiasParaPagar = numeroDiasParaPagar;
    }

	public Long getUsuarioCrea() {
        return this.usuarioCrea;
    }

	public void setUsuarioCrea(Long usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

	public Long getUsuarioModifica() {
        return this.usuarioModifica;
    }

	public void setUsuarioModifica(Long usuarioModifica) {
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
}
