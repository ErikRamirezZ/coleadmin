package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Personal;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Personal.class)
@Controller
@RequestMapping("/personals")
@RooWebScaffold(path = "personals", formBackingObject = Personal.class)
public class PersonalController {
}
