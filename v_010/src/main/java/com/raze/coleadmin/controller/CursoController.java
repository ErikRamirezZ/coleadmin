package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Curso;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Curso.class)
@Controller
@RequestMapping("/cursoes")
@RooWebScaffold(path = "cursoes", formBackingObject = Curso.class)
public class CursoController {
}
