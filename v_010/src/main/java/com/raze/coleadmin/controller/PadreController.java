package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Padre;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Padre.class)
@Controller
@RequestMapping("/padres")
@RooWebScaffold(path = "padres", formBackingObject = Padre.class)
public class PadreController {
}
