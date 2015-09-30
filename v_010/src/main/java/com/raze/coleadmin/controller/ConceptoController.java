package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.Concepto;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Concepto.class)
@Controller
@RequestMapping("/conceptoes")
@RooWebScaffold(path = "conceptoes", formBackingObject = Concepto.class)
public class ConceptoController {
}
