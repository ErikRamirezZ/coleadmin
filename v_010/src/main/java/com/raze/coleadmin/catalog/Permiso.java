package com.raze.coleadmin.catalog;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.json.RooJson;

@RooJavaBean
@RooToString
@RooJpaEntity(versionField = "")
@RooJson(deepSerialize = true)
public class Permiso {

    /**
     */
    @NotNull
    private String nombrePermiso;

    /**
     */
    private String descripcion;

    /**
     */
    private Boolean activo;
}
