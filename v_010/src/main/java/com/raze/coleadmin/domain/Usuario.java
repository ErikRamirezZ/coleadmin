package com.raze.coleadmin.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Lob;
import org.springframework.roo.classpath.operations.jsr303.RooUploadedFile;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(versionField = "")
@RooJson(deepSerialize = true)
public abstract class Usuario {

    /**
     */
    private String correoE;

    /**
     */
    private String password;

    /**
     */
    @NotNull
    @Size(max = 30)
    private String nombre;

    /**
     */
    @NotNull
    @Size(max = 30)
    private String primerApellido;

    /**
     */
    @Size(max = 30)
    private String segundoApellido;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaNacimiento;

    /**
     */
    @RooUploadedFile(contentType = "image/jpeg", autoUpload = true)
    @Lob
    private byte[] foto;

    /**
     */
    @Size(max = 250)
    private String observaciones;

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
}
