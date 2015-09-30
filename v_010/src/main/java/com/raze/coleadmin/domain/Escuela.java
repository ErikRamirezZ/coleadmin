package com.raze.coleadmin.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.catalog.Contacto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

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
}
