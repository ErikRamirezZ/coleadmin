package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.MetodoPago;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = MetodoPago.class)
@Controller
@RequestMapping("/metodopagoes")
@RooWebScaffold(path = "metodopagoes", formBackingObject = MetodoPago.class)
public class MetodoPagoController {
}
