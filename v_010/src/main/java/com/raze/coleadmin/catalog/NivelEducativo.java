package com.raze.coleadmin.catalog;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.domain.Escuela;
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
public class NivelEducativo {

    /**
     */
    @ManyToOne
    private TipoNivelEducativo tipoNivelEducativo;

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

    /**
     */
    private String nombreNivelEducativo;

    /**
     */
    private String clave;

    /**
     */
    private String descripcion;

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

	public static NivelEducativo fromJsonToNivelEducativo(String json) {
        return new JSONDeserializer<NivelEducativo>()
        .use(null, NivelEducativo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<NivelEducativo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<NivelEducativo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<NivelEducativo> fromJsonArrayToNivelEducativoes(String json) {
        return new JSONDeserializer<List<NivelEducativo>>()
        .use("values", NivelEducativo.class).deserialize(json);
    }

	public TipoNivelEducativo getTipoNivelEducativo() {
        return this.tipoNivelEducativo;
    }

	public void setTipoNivelEducativo(TipoNivelEducativo tipoNivelEducativo) {
        this.tipoNivelEducativo = tipoNivelEducativo;
    }

	public Escuela getEscuela() {
        return this.escuela;
    }

	public void setEscuela(Escuela escuela) {
        this.escuela = escuela;
    }

	public String getNombreNivelEducativo() {
        return this.nombreNivelEducativo;
    }

	public void setNombreNivelEducativo(String nombreNivelEducativo) {
        this.nombreNivelEducativo = nombreNivelEducativo;
    }

	public String getClave() {
        return this.clave;
    }

	public void setClave(String clave) {
        this.clave = clave;
    }

	public String getDescripcion() {
        return this.descripcion;
    }

	public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
}
