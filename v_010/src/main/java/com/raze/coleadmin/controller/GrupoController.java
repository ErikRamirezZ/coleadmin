package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Grupo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Grupo.class)
@Controller
@RequestMapping("/grupoes")
@RooWebScaffold(path = "grupoes", formBackingObject = Grupo.class)
public class GrupoController {
}
