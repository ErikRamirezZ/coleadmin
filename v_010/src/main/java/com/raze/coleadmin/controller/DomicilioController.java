package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Domicilio;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Domicilio.class)
@Controller
@RequestMapping("/domicilios")
@RooWebScaffold(path = "domicilios", formBackingObject = Domicilio.class)
public class DomicilioController {
}
