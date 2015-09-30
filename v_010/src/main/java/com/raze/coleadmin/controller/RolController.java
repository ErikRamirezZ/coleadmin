package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.Rol;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Rol.class)
@Controller
@RequestMapping("/rols")
@RooWebScaffold(path = "rols", formBackingObject = Rol.class)
public class RolController {
}
