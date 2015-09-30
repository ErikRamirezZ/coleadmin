package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = ConceptoInscripcionCurso.class)
@Controller
@RequestMapping("/conceptoinscripcioncursoes")
@RooWebScaffold(path = "conceptoinscripcioncursoes", formBackingObject = ConceptoInscripcionCurso.class)
public class ConceptoInscripcionCursoController {
}
