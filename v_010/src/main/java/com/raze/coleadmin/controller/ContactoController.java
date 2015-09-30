package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.Contacto;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Contacto.class)
@Controller
@RequestMapping("/contactoes")
@RooWebScaffold(path = "contactoes", formBackingObject = Contacto.class)
public class ContactoController {
}
