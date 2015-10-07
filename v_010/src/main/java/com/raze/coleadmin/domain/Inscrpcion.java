package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.EstatusInscripcion;
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
public class Inscrpcion {

    /**
     */
    @NotNull
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
    private Grupo grupo;

    /**
     */
    @ManyToOne
    private Alumno alumno;

    /**
     */
    @ManyToOne
    private Padre padre;

    /**
     */
    @ManyToOne
    private EstatusInscripcion estatus;

    /**
     */
    private Double descuentoInscripcion;

    /**
     */
    private Double descuentoColegiatura;

    /**
     */
    private Boolean enviarRecordatorios;

    /**
     */
    private Double saldoActual;

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

	public Grupo getGrupo() {
        return this.grupo;
    }

	public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

	public Alumno getAlumno() {
        return this.alumno;
    }

	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

	public Padre getPadre() {
        return this.padre;
    }

	public void setPadre(Padre padre) {
        this.padre = padre;
    }

	public EstatusInscripcion getEstatus() {
        return this.estatus;
    }

	public void setEstatus(EstatusInscripcion estatus) {
        this.estatus = estatus;
    }

	public Double getDescuentoInscripcion() {
        return this.descuentoInscripcion;
    }

	public void setDescuentoInscripcion(Double descuentoInscripcion) {
        this.descuentoInscripcion = descuentoInscripcion;
    }

	public Double getDescuentoColegiatura() {
        return this.descuentoColegiatura;
    }

	public void setDescuentoColegiatura(Double descuentoColegiatura) {
        this.descuentoColegiatura = descuentoColegiatura;
    }

	public Boolean getEnviarRecordatorios() {
        return this.enviarRecordatorios;
    }

	public void setEnviarRecordatorios(Boolean enviarRecordatorios) {
        this.enviarRecordatorios = enviarRecordatorios;
    }

	public Double getSaldoActual() {
        return this.saldoActual;
    }

	public void setSaldoActual(Double saldoActual) {
        this.saldoActual = saldoActual;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Inscrpcion fromJsonToInscrpcion(String json) {
        return new JSONDeserializer<Inscrpcion>()
        .use(null, Inscrpcion.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Inscrpcion> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Inscrpcion> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Inscrpcion> fromJsonArrayToInscrpcions(String json) {
        return new JSONDeserializer<List<Inscrpcion>>()
        .use("values", Inscrpcion.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
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
}
