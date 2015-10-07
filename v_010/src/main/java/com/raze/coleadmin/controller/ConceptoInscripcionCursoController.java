package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.ConceptoInscripcionCurso;
import com.raze.coleadmin.service.ConceptoInscripcionCursoService;
import com.raze.coleadmin.service.CursoService;
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

@RooWebJson(jsonObject = ConceptoInscripcionCurso.class)
@Controller
@RequestMapping("/conceptoinscripcioncursoes")
@RooWebScaffold(path = "conceptoinscripcioncursoes", formBackingObject = ConceptoInscripcionCurso.class)
public class ConceptoInscripcionCursoController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            ConceptoInscripcionCurso conceptoInscripcionCurso = conceptoInscripcionCursoService.findConceptoInscripcionCurso(id);
            if (conceptoInscripcionCurso == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(conceptoInscripcionCurso.toJson(), headers, HttpStatus.OK);
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
            List<ConceptoInscripcionCurso> result = conceptoInscripcionCursoService.findAllConceptoInscripcionCursoes();
            return new ResponseEntity<String>(ConceptoInscripcionCurso.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ConceptoInscripcionCurso conceptoInscripcionCurso = ConceptoInscripcionCurso.fromJsonToConceptoInscripcionCurso(json);
            conceptoInscripcionCursoService.saveConceptoInscripcionCurso(conceptoInscripcionCurso);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+conceptoInscripcionCurso.getId().toString()).build().toUriString());
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
            for (ConceptoInscripcionCurso conceptoInscripcionCurso: ConceptoInscripcionCurso.fromJsonArrayToConceptoInscripcionCursoes(json)) {
                conceptoInscripcionCursoService.saveConceptoInscripcionCurso(conceptoInscripcionCurso);
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
            ConceptoInscripcionCurso conceptoInscripcionCurso = ConceptoInscripcionCurso.fromJsonToConceptoInscripcionCurso(json);
            conceptoInscripcionCurso.setId(id);
            if (conceptoInscripcionCursoService.updateConceptoInscripcionCurso(conceptoInscripcionCurso) == null) {
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
            ConceptoInscripcionCurso conceptoInscripcionCurso = conceptoInscripcionCursoService.findConceptoInscripcionCurso(id);
            if (conceptoInscripcionCurso == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            conceptoInscripcionCursoService.deleteConceptoInscripcionCurso(conceptoInscripcionCurso);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    CursoService cursoService;

	@Autowired
    ConceptoInscripcionCursoService conceptoInscripcionCursoService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ConceptoInscripcionCurso conceptoInscripcionCurso, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, conceptoInscripcionCurso);
            return "conceptoinscripcioncursoes/create";
        }
        uiModel.asMap().clear();
        conceptoInscripcionCursoService.saveConceptoInscripcionCurso(conceptoInscripcionCurso);
        return "redirect:/conceptoinscripcioncursoes/" + encodeUrlPathSegment(conceptoInscripcionCurso.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ConceptoInscripcionCurso());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (cursoService.countAllCursoes() == 0) {
            dependencies.add(new String[] { "curso", "cursoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "conceptoinscripcioncursoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("conceptoinscripcioncurso", conceptoInscripcionCursoService.findConceptoInscripcionCurso(id));
        uiModel.addAttribute("itemId", id);
        return "conceptoinscripcioncursoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("conceptoinscripcioncursoes", conceptoInscripcionCursoService.findConceptoInscripcionCursoEntries(firstResult, sizeNo));
            float nrOfPages = (float) conceptoInscripcionCursoService.countAllConceptoInscripcionCursoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("conceptoinscripcioncursoes", conceptoInscripcionCursoService.findAllConceptoInscripcionCursoes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "conceptoinscripcioncursoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ConceptoInscripcionCurso conceptoInscripcionCurso, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, conceptoInscripcionCurso);
            return "conceptoinscripcioncursoes/update";
        }
        uiModel.asMap().clear();
        conceptoInscripcionCursoService.updateConceptoInscripcionCurso(conceptoInscripcionCurso);
        return "redirect:/conceptoinscripcioncursoes/" + encodeUrlPathSegment(conceptoInscripcionCurso.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, conceptoInscripcionCursoService.findConceptoInscripcionCurso(id));
        return "conceptoinscripcioncursoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ConceptoInscripcionCurso conceptoInscripcionCurso = conceptoInscripcionCursoService.findConceptoInscripcionCurso(id);
        conceptoInscripcionCursoService.deleteConceptoInscripcionCurso(conceptoInscripcionCurso);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/conceptoinscripcioncursoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("conceptoInscripcionCurso_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("conceptoInscripcionCurso_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, ConceptoInscripcionCurso conceptoInscripcionCurso) {
        uiModel.addAttribute("conceptoInscripcionCurso", conceptoInscripcionCurso);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("cursoes", cursoService.findAllCursoes());
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
}
