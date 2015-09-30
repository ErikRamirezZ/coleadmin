package com.raze.coleadmin.catalog;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import com.raze.coleadmin.domain.Escuela;
import javax.persistence.ManyToOne;
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
}
