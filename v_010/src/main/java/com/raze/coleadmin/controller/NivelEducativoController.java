package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.NivelEducativo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = NivelEducativo.class)
@Controller
@RequestMapping("/niveleducativoes")
@RooWebScaffold(path = "niveleducativoes", formBackingObject = NivelEducativo.class)
public class NivelEducativoController {
}
