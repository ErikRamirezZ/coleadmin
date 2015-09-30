package com.raze.coleadmin.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.EstatusInscripcion;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

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
}
