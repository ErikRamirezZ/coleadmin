package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.Permiso;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Permiso.class)
@Controller
@RequestMapping("/permisoes")
@RooWebScaffold(path = "permisoes", formBackingObject = Permiso.class)
public class PermisoController {
}
