package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.raze.coleadmin.catalog.TipoEscuela;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Escuela {

    /**
     */
    private String clave;

    /**
     */
    @Enumerated
    private TipoEscuela tipoEscuela;

    /**
     */
    private String nombre;

    /**
     */
    private String razonSocial;

    /**
     */
    @Lob
    private byte[] logo;

    /**
     */
    private String contentType;

    /**
     */
    private Long idUsuario;

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

	public String getClave() {
        return this.clave;
    }

	public void setClave(String clave) {
        this.clave = clave;
    }

	public TipoEscuela getTipoEscuela() {
        return this.tipoEscuela;
    }

	public void setTipoEscuela(TipoEscuela tipoEscuela) {
        this.tipoEscuela = tipoEscuela;
    }

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getRazonSocial() {
        return this.razonSocial;
    }

	public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

	public byte[] getLogo() {
        return this.logo;
    }

	public void setLogo(byte[] logo) {
        this.logo = logo;
    }

	public String getContentType() {
        return this.contentType;
    }

	public void setContentType(String contentType) {
        this.contentType = contentType;
    }

	public Long getIdUsuario() {
        return this.idUsuario;
    }

	public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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

	public static Escuela fromJsonToEscuela(String json) {
        return new JSONDeserializer<Escuela>()
        .use(null, Escuela.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Escuela> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Escuela> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Escuela> fromJsonArrayToEscuelas(String json) {
        return new JSONDeserializer<List<Escuela>>()
        .use("values", Escuela.class).deserialize(json);
    }
}
