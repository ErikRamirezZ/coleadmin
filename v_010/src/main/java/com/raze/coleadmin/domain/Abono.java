package com.raze.coleadmin.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
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
import com.raze.coleadmin.catalog.MetodoPago;
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
public class Abono {

    /**
     */
    @NotNull
    @ManyToOne
    private Alumno alumno;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Cargo> cargo = new HashSet<Cargo>();

    /**
     */
    @ManyToOne
    private MetodoPago metodoPago;

    /**
     */
    private Double total;

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

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static Abono fromJsonToAbono(String json) {
        return new JSONDeserializer<Abono>()
        .use(null, Abono.class).deserialize(json);
    }

	public static String toJsonArray(Collection<Abono> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<Abono> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<Abono> fromJsonArrayToAbonoes(String json) {
        return new JSONDeserializer<List<Abono>>()
        .use("values", Abono.class).deserialize(json);
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

	public Alumno getAlumno() {
        return this.alumno;
    }

	public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

	public Set<Cargo> getCargo() {
        return this.cargo;
    }

	public void setCargo(Set<Cargo> cargo) {
        this.cargo = cargo;
    }

	public MetodoPago getMetodoPago() {
        return this.metodoPago;
    }

	public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

	public Double getTotal() {
        return this.total;
    }

	public void setTotal(Double total) {
        this.total = total;
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
}
