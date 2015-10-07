package com.raze.coleadmin.catalog;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import com.raze.coleadmin.domain.Escuela;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.domain.Usuario;
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
public class CorreoNotificaciones {

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

    /**
     */
    private String email;

    /**
     */
    private String password;

    /**
     */
    private String host;

    /**
     */
    private String port;

    /**
     */
    private String protocol;

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

	public String getEmail() {
        return this.email;
    }

	public void setEmail(String email) {
        this.email = email;
    }

	public String getPassword() {
        return this.password;
    }

	public void setPassword(String password) {
        this.password = password;
    }

	public String getHost() {
        return this.host;
    }

	public void setHost(String host) {
        this.host = host;
    }

	public String getPort() {
        return this.port;
    }

	public void setPort(String port) {
        this.port = port;
    }

	public String getProtocol() {
        return this.protocol;
    }

	public void setProtocol(String protocol) {
        this.protocol = protocol;
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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static CorreoNotificaciones fromJsonToCorreoNotificaciones(String json) {
        return new JSONDeserializer<CorreoNotificaciones>()
        .use(null, CorreoNotificaciones.class).deserialize(json);
    }

	public static String toJsonArray(Collection<CorreoNotificaciones> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<CorreoNotificaciones> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<CorreoNotificaciones> fromJsonArrayToCorreoNotificacioneses(String json) {
        return new JSONDeserializer<List<CorreoNotificaciones>>()
        .use("values", CorreoNotificaciones.class).deserialize(json);
    }
}
