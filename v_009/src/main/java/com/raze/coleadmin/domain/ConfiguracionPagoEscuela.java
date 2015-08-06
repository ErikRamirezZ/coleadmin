package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.catalog.Modulo;
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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ConfiguracionPagoEscuela {

    /**
     */
    @ManyToOne
    private Escuela escuela;

    /**
     */
    private Integer diaPago;

    /**
     */
    private String nip;

    /**
     */
    private String fechaVencimiento;

    /**
     */
    private String correoE;

    /**
     */
    private String numeroTelefonico;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Modulo> modulos = new HashSet<Modulo>();

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

	public Integer getDiaPago() {
        return this.diaPago;
    }

	public void setDiaPago(Integer diaPago) {
        this.diaPago = diaPago;
    }

	public String getNip() {
        return this.nip;
    }

	public void setNip(String nip) {
        this.nip = nip;
    }

	public String getFechaVencimiento() {
        return this.fechaVencimiento;
    }

	public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

	public String getCorreoE() {
        return this.correoE;
    }

	public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

	public String getNumeroTelefonico() {
        return this.numeroTelefonico;
    }

	public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

	public Set<Modulo> getModulos() {
        return this.modulos;
    }

	public void setModulos(Set<Modulo> modulos) {
        this.modulos = modulos;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static ConfiguracionPagoEscuela fromJsonToConfiguracionPagoEscuela(String json) {
        return new JSONDeserializer<ConfiguracionPagoEscuela>()
        .use(null, ConfiguracionPagoEscuela.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ConfiguracionPagoEscuela> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ConfiguracionPagoEscuela> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ConfiguracionPagoEscuela> fromJsonArrayToConfiguracionPagoEscuelas(String json) {
        return new JSONDeserializer<List<ConfiguracionPagoEscuela>>()
        .use("values", ConfiguracionPagoEscuela.class).deserialize(json);
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

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
