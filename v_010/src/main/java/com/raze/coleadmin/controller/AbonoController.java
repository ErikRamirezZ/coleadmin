package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Abono;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Abono.class)
@Controller
@RequestMapping("/abonoes")
@RooWebScaffold(path = "abonoes", formBackingObject = Abono.class)
public class AbonoController {
}
