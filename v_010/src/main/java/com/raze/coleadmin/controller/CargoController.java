package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Cargo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Cargo.class)
@Controller
@RequestMapping("/cargoes")
@RooWebScaffold(path = "cargoes", formBackingObject = Cargo.class)
public class CargoController {
}
