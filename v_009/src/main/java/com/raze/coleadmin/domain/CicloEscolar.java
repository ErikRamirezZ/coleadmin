package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
public class CicloEscolar {

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaInicio;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaFin;

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

	public Escuela getEscuela() {
        return this.escuela;
    }

	public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public Date getFechaInicio() {
        return this.fechaInicio;
    }

	public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

	public Date getFechaFin() {
        return this.fechaFin;
    }

	public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

	public static CicloEscolar fromJsonToCicloEscolar(String json) {
        return new JSONDeserializer<CicloEscolar>()
        .use(null, CicloEscolar.class).deserialize(json);
    }

	public static String toJsonArray(Collection<CicloEscolar> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<CicloEscolar> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<CicloEscolar> fromJsonArrayToCicloEscolars(String json) {
        return new JSONDeserializer<List<CicloEscolar>>()
        .use("values", CicloEscolar.class).deserialize(json);
    }
}
