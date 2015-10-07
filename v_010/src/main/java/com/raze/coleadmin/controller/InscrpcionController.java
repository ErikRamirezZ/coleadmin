package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Inscrpcion;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.CicloEscolarService;
import com.raze.coleadmin.service.CursoService;
import com.raze.coleadmin.service.EscuelaService;
import com.raze.coleadmin.service.EstatusInscripcionService;
import com.raze.coleadmin.service.GrupoService;
import com.raze.coleadmin.service.InscrpcionService;
import com.raze.coleadmin.service.PadreService;
import com.raze.coleadmin.service.UsuarioService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Inscrpcion.class)
@Controller
@RequestMapping("/inscrpcions")
@RooWebScaffold(path = "inscrpcions", formBackingObject = Inscrpcion.class)
public class InscrpcionController {

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    InscrpcionService inscrpcionService;

	@Autowired
    EstatusInscripcionService estatusInscripcionService;

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    CicloEscolarService cicloEscolarService;

	@Autowired
    CursoService cursoService;

	@Autowired
    GrupoService grupoService;

	@Autowired
    PadreService padreService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Inscrpcion inscrpcion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, inscrpcion);
            return "inscrpcions/create";
        }
        uiModel.asMap().clear();
        inscrpcionService.saveInscrpcion(inscrpcion);
        return "redirect:/inscrpcions/" + encodeUrlPathSegment(inscrpcion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Inscrpcion());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (escuelaService.countAllEscuelas() == 0) {
            dependencies.add(new String[] { "escuela", "escuelas" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "inscrpcions/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("inscrpcion", inscrpcionService.findInscrpcion(id));
        uiModel.addAttribute("itemId", id);
        return "inscrpcions/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("inscrpcions", inscrpcionService.findInscrpcionEntries(firstResult, sizeNo));
            float nrOfPages = (float) inscrpcionService.countAllInscrpcions() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("inscrpcions", inscrpcionService.findAllInscrpcions());
        }
        addDateTimeFormatPatterns(uiModel);
        return "inscrpcions/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Inscrpcion inscrpcion, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, inscrpcion);
            return "inscrpcions/update";
        }
        uiModel.asMap().clear();
        inscrpcionService.updateInscrpcion(inscrpcion);
        return "redirect:/inscrpcions/" + encodeUrlPathSegment(inscrpcion.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, inscrpcionService.findInscrpcion(id));
        return "inscrpcions/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Inscrpcion inscrpcion = inscrpcionService.findInscrpcion(id);
        inscrpcionService.deleteInscrpcion(inscrpcion);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/inscrpcions";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("inscrpcion_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("inscrpcion_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Inscrpcion inscrpcion) {
        uiModel.addAttribute("inscrpcion", inscrpcion);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("estatusinscripcions", estatusInscripcionService.findAllEstatusInscripcions());
        uiModel.addAttribute("alumnoes", alumnoService.findAllAlumnoes());
        uiModel.addAttribute("cicloescolars", cicloEscolarService.findAllCicloEscolars());
        uiModel.addAttribute("cursoes", cursoService.findAllCursoes());
        uiModel.addAttribute("escuelas", escuelaService.findAllEscuelas());
        uiModel.addAttribute("grupoes", grupoService.findAllGrupoes());
        uiModel.addAttribute("padres", padreService.findAllPadres());
        uiModel.addAttribute("usuarios", usuarioService.findAllUsuarios());
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Inscrpcion inscrpcion = inscrpcionService.findInscrpcion(id);
            if (inscrpcion == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(inscrpcion.toJson(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<Inscrpcion> result = inscrpcionService.findAllInscrpcions();
            return new ResponseEntity<String>(Inscrpcion.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Inscrpcion inscrpcion = Inscrpcion.fromJsonToInscrpcion(json);
            inscrpcionService.saveInscrpcion(inscrpcion);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+inscrpcion.getId().toString()).build().toUriString());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            for (Inscrpcion inscrpcion: Inscrpcion.fromJsonArrayToInscrpcions(json)) {
                inscrpcionService.saveInscrpcion(inscrpcion);
            }
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Inscrpcion inscrpcion = Inscrpcion.fromJsonToInscrpcion(json);
            inscrpcion.setId(id);
            if (inscrpcionService.updateInscrpcion(inscrpcion) == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Inscrpcion inscrpcion = inscrpcionService.findInscrpcion(id);
            if (inscrpcion == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            inscrpcionService.deleteInscrpcion(inscrpcion);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
