package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Inscrpcion;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Inscrpcion.class)
@Controller
@RequestMapping("/inscrpcions")
@RooWebScaffold(path = "inscrpcions", formBackingObject = Inscrpcion.class)
public class InscrpcionController {
}
