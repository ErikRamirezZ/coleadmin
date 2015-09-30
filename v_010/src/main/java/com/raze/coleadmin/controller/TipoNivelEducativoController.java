package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.TipoNivelEducativo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = TipoNivelEducativo.class)
@Controller
@RequestMapping("/tiponiveleducativoes")
@RooWebScaffold(path = "tiponiveleducativoes", formBackingObject = TipoNivelEducativo.class)
public class TipoNivelEducativoController {
}
