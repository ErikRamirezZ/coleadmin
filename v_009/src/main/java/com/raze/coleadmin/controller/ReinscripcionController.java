package com.raze.coleadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reinscripciones")
public class ReinscripcionController {

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        return "reinscripciones/create";
    }
	
}
