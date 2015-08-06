package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.catalog.EstatusCuenta;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
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
public class Cuenta {

    /**
     */
    @ManyToOne
    private Escuela escuela;

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
    private Padre padre;

    /**
     */
    @ManyToOne
    private Alumno alumno;

    /**
     */
    private Integer descuentoInscripcion;

    /**
     */
    private Integer descuentoMensualidad;

    /**
     */
    private Boolean enviarRecordatorio;

    /**
     */
    private Double saldoTotal;

    /**
     */
    @NotNull
    @ManyToOne
    private EstatusCuenta estatus;

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

	public Padre getPadre() {
        return this.padre;
    }

	public void setPadre(Padre padre) {
        this.padre = padre;
    }

	public Alumno getAlumno() {
        return this.alumno;
    }

	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

	public Integer getDescuentoInscripcion() {
        return this.descuentoInscripcion;
    }

	public void setDescuentoInscripcion(Integer descuentoInscripcion) {
        this.descuentoInscripcion = descuentoInscripcion;
    }

	public Integer getDescuentoMensualidad() {
        return this.descuentoMensualidad;
    }

	public void setDescuentoMensualidad(Integer descuentoMensualidad) {
        this.descuentoMensualidad = descuentoMensualidad;
    }

	public Boolean getEnviarRecordatorio() {
        return this.enviarRecordatorio;
    }

	public void setEnviarRecordatorio(Boolean enviarRecordatorio) {
        this.enviarRecordatorio = enviarRecordatorio;
    }

	public Double getSaldoTotal() {
        return this.saldoTotal;
    }

	public void setSaldoTotal(Double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

	public EstatusCuenta getEstatus() {
        return this.estatus;
    }

	public void setEstatus(EstatusCuenta estatus) {
        this.estatus = estatus;
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
