package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Asistencia;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Asistencia.class)
@Controller
@RequestMapping("/asistencias")
@RooWebScaffold(path = "asistencias", formBackingObject = Asistencia.class)
public class AsistenciaController {
}
