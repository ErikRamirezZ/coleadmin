package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.Categoria;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Categoria.class)
@Controller
@RequestMapping("/categorias")
@RooWebScaffold(path = "categorias", formBackingObject = Categoria.class)
public class CategoriaController {
}
