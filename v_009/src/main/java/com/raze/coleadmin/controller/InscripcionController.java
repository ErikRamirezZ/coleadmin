package com.raze.coleadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inscripciones")
public class InscripcionController {

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        return "inscripciones/create";
    }
	
	
}
