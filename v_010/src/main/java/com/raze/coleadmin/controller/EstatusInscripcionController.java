package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.EstatusInscripcion;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = EstatusInscripcion.class)
@Controller
@RequestMapping("/estatusinscripcions")
@RooWebScaffold(path = "estatusinscripcions", formBackingObject = EstatusInscripcion.class)
public class EstatusInscripcionController {
}
