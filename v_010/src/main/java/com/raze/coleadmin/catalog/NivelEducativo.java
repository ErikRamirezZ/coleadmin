package com.raze.coleadmin.catalog;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import com.raze.coleadmin.domain.Escuela;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.domain.Usuario;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

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
}
