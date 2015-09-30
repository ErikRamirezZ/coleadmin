package com.raze.coleadmin.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.Concepto;
import com.raze.coleadmin.catalog.EstatusCargo;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Cargo {

    /**
     */
    @NotNull
    @ManyToOne
    private Alumno alumno;

    /**
     */
    @NotNull
    @ManyToOne
    private Concepto concepto;

    /**
     */
    @NotNull
    private Double cantidad;

    /**
     */
    @NotNull
    private Double subtotal;

    /**
     */
    private Double descuentoPorcentaje;

    /**
     */
    private Double descuentoPesos;

    /**
     */
    @NotNull
    private Double total;

    /**
     */
    @ManyToOne
    private EstatusCargo estatusCargo;

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
