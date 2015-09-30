package com.raze.coleadmin.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.raze.coleadmin.catalog.Contacto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import com.raze.coleadmin.catalog.Rol;
import com.raze.coleadmin.catalog.Permiso;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Alumno extends Usuario {

    /**
     */
    @NotNull
    @ManyToOne
    private Escuela escuela;

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
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Rol> roles = new HashSet<Rol>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Permiso> permisos = new HashSet<Permiso>();

    /**
     */
    private String curp;

    /**
     */
    private String tipoSangre;

    /**
     */
    private String talla;

    /**
     */
    private String peso;

    /**
     */
    private String alergias;

    /**
     */
    private String folio;
}
