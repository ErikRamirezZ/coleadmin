package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.EstatusCargo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = EstatusCargo.class)
@Controller
@RequestMapping("/estatuscargoes")
@RooWebScaffold(path = "estatuscargoes", formBackingObject = EstatusCargo.class)
public class EstatusCargoController {
}
