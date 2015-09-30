package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = CorreoNotificaciones.class)
@Controller
@RequestMapping("/correonotificacioneses")
@RooWebScaffold(path = "correonotificacioneses", formBackingObject = CorreoNotificaciones.class)
public class CorreoNotificacionesController {
}
