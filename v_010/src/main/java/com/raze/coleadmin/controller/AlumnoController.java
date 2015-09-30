package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Alumno;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Alumno.class)
@Controller
@RequestMapping("/alumnoes")
@RooWebScaffold(path = "alumnoes", formBackingObject = Alumno.class)
public class AlumnoController {
}
