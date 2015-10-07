package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.catalog.Contacto;
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
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Escuela {

    /**
     */
    @NotNull
    private String nombre;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] logo;

    /**
     */
    private String web;

    /**
     */
    private String razonSocial;

    /**
     */
    @ManyToOne
    private Domicilio domicilio;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Contacto> contactos = new HashSet<Contacto>();

    /**
     */
    @ManyToOne
    private CorreoNotificaciones correo;

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

	public String getNombre() {
        return this.nombre;
    }

	public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public byte[] getLogo() {
        return this.logo;
    }

	public void setLogo(byte[] logo) {
        this.logo = logo;
    }

	public String getWeb() {
        return this.web;
    }

	public void setWeb(String web) {
        this.web = web;
    }

	public String getRazonSocial() {
        return this.razonSocial;
    }

	public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

	public Domicilio getDomicilio() {
        return this.domicilio;
    }

	public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

	public Set<Contacto> getContactos() {
        return this.contactos;
    }

	public void setContactos(Set<Contacto> contactos) {
        this.contactos = contactos;
    }

	public CorreoNotificaciones getCorreo() {
        return this.correo;
    }

	public void setCorreo(CorreoNotificaciones correo) {
        this.correo = correo;
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
