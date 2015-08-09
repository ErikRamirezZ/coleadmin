package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.AlumnoGrupo;
import com.raze.coleadmin.service.AlumnoGrupoService;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.GrupoService;
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

@RooWebJson(jsonObject = AlumnoGrupo.class)
@Controller
@RequestMapping("/alumnogrupoes")
@RooWebScaffold(path = "alumnogrupoes", formBackingObject = AlumnoGrupo.class)
public class AlumnoGrupoController {

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    AlumnoGrupoService alumnoGrupoService;

	@Autowired
    GrupoService grupoService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid AlumnoGrupo alumnoGrupo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alumnoGrupo);
            return "alumnogrupoes/create";
        }
        uiModel.asMap().clear();
        alumnoGrupoService.saveAlumnoGrupo(alumnoGrupo);
        return "redirect:/alumnogrupoes/" + encodeUrlPathSegment(alumnoGrupo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new AlumnoGrupo());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (alumnoService.countAllAlumnoes() == 0) {
            dependencies.add(new String[] { "alumno", "alumnoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "alumnogrupoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("alumnogrupo", alumnoGrupoService.findAlumnoGrupo(id));
        uiModel.addAttribute("itemId", id);
        return "alumnogrupoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("alumnogrupoes", alumnoGrupoService.findAlumnoGrupoEntries(firstResult, sizeNo));
            float nrOfPages = (float) alumnoGrupoService.countAllAlumnoGrupoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("alumnogrupoes", alumnoGrupoService.findAllAlumnoGrupoes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "alumnogrupoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid AlumnoGrupo alumnoGrupo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, alumnoGrupo);
            return "alumnogrupoes/update";
        }
        uiModel.asMap().clear();
        alumnoGrupoService.updateAlumnoGrupo(alumnoGrupo);
        return "redirect:/alumnogrupoes/" + encodeUrlPathSegment(alumnoGrupo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, alumnoGrupoService.findAlumnoGrupo(id));
        return "alumnogrupoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        AlumnoGrupo alumnoGrupo = alumnoGrupoService.findAlumnoGrupo(id);
        alumnoGrupoService.deleteAlumnoGrupo(alumnoGrupo);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/alumnogrupoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("alumnoGrupo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("alumnoGrupo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, AlumnoGrupo alumnoGrupo) {
        uiModel.addAttribute("alumnoGrupo", alumnoGrupo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("alumnoes", alumnoService.findAllAlumnoes());
        uiModel.addAttribute("grupoes", grupoService.findAllGrupoes());
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
            AlumnoGrupo alumnoGrupo = alumnoGrupoService.findAlumnoGrupo(id);
            if (alumnoGrupo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(alumnoGrupo.toJson(), headers, HttpStatus.OK);
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
            List<AlumnoGrupo> result = alumnoGrupoService.findAllAlumnoGrupoes();
            return new ResponseEntity<String>(AlumnoGrupo.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            AlumnoGrupo alumnoGrupo = AlumnoGrupo.fromJsonToAlumnoGrupo(json);
            alumnoGrupoService.saveAlumnoGrupo(alumnoGrupo);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+alumnoGrupo.getId().toString()).build().toUriString());
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
            for (AlumnoGrupo alumnoGrupo: AlumnoGrupo.fromJsonArrayToAlumnoGrupoes(json)) {
                alumnoGrupoService.saveAlumnoGrupo(alumnoGrupo);
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
            AlumnoGrupo alumnoGrupo = AlumnoGrupo.fromJsonToAlumnoGrupo(json);
            alumnoGrupo.setId(id);
            if (alumnoGrupoService.updateAlumnoGrupo(alumnoGrupo) == null) {
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
            AlumnoGrupo alumnoGrupo = alumnoGrupoService.findAlumnoGrupo(id);
            if (alumnoGrupo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            alumnoGrupoService.deleteAlumnoGrupo(alumnoGrupo);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
