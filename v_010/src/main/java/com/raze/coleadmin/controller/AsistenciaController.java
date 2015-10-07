package com.raze.coleadmin.controller;
import com.raze.coleadmin.domain.Asistencia;
import com.raze.coleadmin.service.AlumnoService;
import com.raze.coleadmin.service.AsistenciaService;
import com.raze.coleadmin.service.TipoAsistenciaService;
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

@RooWebJson(jsonObject = Asistencia.class)
@Controller
@RequestMapping("/asistencias")
@RooWebScaffold(path = "asistencias", formBackingObject = Asistencia.class)
public class AsistenciaController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            Asistencia asistencia = asistenciaService.findAsistencia(id);
            if (asistencia == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(asistencia.toJson(), headers, HttpStatus.OK);
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
            List<Asistencia> result = asistenciaService.findAllAsistencias();
            return new ResponseEntity<String>(Asistencia.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Asistencia asistencia = Asistencia.fromJsonToAsistencia(json);
            asistenciaService.saveAsistencia(asistencia);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+asistencia.getId().toString()).build().toUriString());
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
            for (Asistencia asistencia: Asistencia.fromJsonArrayToAsistencias(json)) {
                asistenciaService.saveAsistencia(asistencia);
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
            Asistencia asistencia = Asistencia.fromJsonToAsistencia(json);
            asistencia.setId(id);
            if (asistenciaService.updateAsistencia(asistencia) == null) {
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
            Asistencia asistencia = asistenciaService.findAsistencia(id);
            if (asistencia == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            asistenciaService.deleteAsistencia(asistencia);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    AlumnoService alumnoService;

	@Autowired
    TipoAsistenciaService tipoAsistenciaService;

	@Autowired
    AsistenciaService asistenciaService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Asistencia asistencia, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, asistencia);
            return "asistencias/create";
        }
        uiModel.asMap().clear();
        asistenciaService.saveAsistencia(asistencia);
        return "redirect:/asistencias/" + encodeUrlPathSegment(asistencia.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Asistencia());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (alumnoService.countAllAlumnoes() == 0) {
            dependencies.add(new String[] { "alumno", "alumnoes" });
        }
        if (tipoAsistenciaService.countAllTipoAsistencias() == 0) {
            dependencies.add(new String[] { "tipoAsistencia", "tipoasistencias" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "asistencias/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("asistencia", asistenciaService.findAsistencia(id));
        uiModel.addAttribute("itemId", id);
        return "asistencias/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("asistencias", asistenciaService.findAsistenciaEntries(firstResult, sizeNo));
            float nrOfPages = (float) asistenciaService.countAllAsistencias() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("asistencias", asistenciaService.findAllAsistencias());
        }
        addDateTimeFormatPatterns(uiModel);
        return "asistencias/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Asistencia asistencia, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, asistencia);
            return "asistencias/update";
        }
        uiModel.asMap().clear();
        asistenciaService.updateAsistencia(asistencia);
        return "redirect:/asistencias/" + encodeUrlPathSegment(asistencia.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, asistenciaService.findAsistencia(id));
        return "asistencias/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Asistencia asistencia = asistenciaService.findAsistencia(id);
        asistenciaService.deleteAsistencia(asistencia);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/asistencias";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("asistencia_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("asistencia_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Asistencia asistencia) {
        uiModel.addAttribute("asistencia", asistencia);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("tipoasistencias", tipoAsistenciaService.findAllTipoAsistencias());
        uiModel.addAttribute("alumnoes", alumnoService.findAllAlumnoes());
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
