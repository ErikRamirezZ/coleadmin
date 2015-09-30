package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.TipoAsistencia;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = TipoAsistencia.class)
@Controller
@RequestMapping("/tipoasistencias")
@RooWebScaffold(path = "tipoasistencias", formBackingObject = TipoAsistencia.class)
public class TipoAsistenciaController {
}
