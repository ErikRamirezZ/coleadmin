package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import javax.validation.constraints.NotNull;
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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Domicilio {

    /**
     */
    @NotNull
    private String calle;

    /**
     */
    private String numeroInt;

    /**
     */
    private String numeroExt;

    /**
     */
    private String colonia;

    /**
     */
    private String cp;

    /**
     */
    private String municipio;

    /**
     */
    private String estado;

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

	public String getCalle() {
        return this.calle;
    }

	public void setCalle(String calle) {
        this.calle = calle;
    }

	public String getNumeroInt() {
        return this.numeroInt;
    }

	public void setNumeroInt(String numeroInt) {
        this.numeroInt = numeroInt;
    }

	public String getNumeroExt() {
        return this.numeroExt;
    }

	public void setNumeroExt(String numeroExt) {
        this.numeroExt = numeroExt;
    }

	public String getColonia() {
        return this.colonia;
    }

	public void setColonia(String colonia) {
        this.colonia = colonia;
    }

	public String getCp() {
        return this.cp;
    }

	public void setCp(String cp) {
        this.cp = cp;
    }

	public String getMunicipio() {
        return this.municipio;
    }

	public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

	public String getEstado() {
        return this.estado;
    }

	public void setEstado(String estado) {
        this.estado = estado;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Domicilio fromJsonToDomicilio(String json) {
        return new JSONDeserializer<Domicilio>()
        .use(null, Domicilio.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Domicilio> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Domicilio> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Domicilio> fromJsonArrayToDomicilios(String json) {
        return new JSONDeserializer<List<Domicilio>>()
        .use("values", Domicilio.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
