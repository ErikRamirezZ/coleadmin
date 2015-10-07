package com.raze.coleadmin.controller;
import com.raze.coleadmin.catalog.CorreoNotificaciones;
import com.raze.coleadmin.service.CorreoNotificacionesService;
import com.raze.coleadmin.service.EscuelaService;
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

@RooWebJson(jsonObject = CorreoNotificaciones.class)
@Controller
@RequestMapping("/correonotificacioneses")
@RooWebScaffold(path = "correonotificacioneses", formBackingObject = CorreoNotificaciones.class)
public class CorreoNotificacionesController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            CorreoNotificaciones correoNotificaciones = correoNotificacionesService.findCorreoNotificaciones(id);
            if (correoNotificaciones == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(correoNotificaciones.toJson(), headers, HttpStatus.OK);
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
            List<CorreoNotificaciones> result = correoNotificacionesService.findAllCorreoNotificacioneses();
            return new ResponseEntity<String>(CorreoNotificaciones.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            CorreoNotificaciones correoNotificaciones = CorreoNotificaciones.fromJsonToCorreoNotificaciones(json);
            correoNotificacionesService.saveCorreoNotificaciones(correoNotificaciones);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+correoNotificaciones.getId().toString()).build().toUriString());
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
            for (CorreoNotificaciones correoNotificaciones: CorreoNotificaciones.fromJsonArrayToCorreoNotificacioneses(json)) {
                correoNotificacionesService.saveCorreoNotificaciones(correoNotificaciones);
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
            CorreoNotificaciones correoNotificaciones = CorreoNotificaciones.fromJsonToCorreoNotificaciones(json);
            correoNotificaciones.setId(id);
            if (correoNotificacionesService.updateCorreoNotificaciones(correoNotificaciones) == null) {
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
            CorreoNotificaciones correoNotificaciones = correoNotificacionesService.findCorreoNotificaciones(id);
            if (correoNotificaciones == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            correoNotificacionesService.deleteCorreoNotificaciones(correoNotificaciones);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    EscuelaService escuelaService;

	@Autowired
    CorreoNotificacionesService correoNotificacionesService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid CorreoNotificaciones correoNotificaciones, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, correoNotificaciones);
            return "correonotificacioneses/create";
        }
        uiModel.asMap().clear();
        correoNotificacionesService.saveCorreoNotificaciones(correoNotificaciones);
        return "redirect:/correonotificacioneses/" + encodeUrlPathSegment(correoNotificaciones.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new CorreoNotificaciones());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (escuelaService.countAllEscuelas() == 0) {
            dependencies.add(new String[] { "escuela", "escuelas" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "correonotificacioneses/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("correonotificaciones", correoNotificacionesService.findCorreoNotificaciones(id));
        uiModel.addAttribute("itemId", id);
        return "correonotificacioneses/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("correonotificacioneses", correoNotificacionesService.findCorreoNotificacionesEntries(firstResult, sizeNo));
            float nrOfPages = (float) correoNotificacionesService.countAllCorreoNotificacioneses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("correonotificacioneses", correoNotificacionesService.findAllCorreoNotificacioneses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "correonotificacioneses/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid CorreoNotificaciones correoNotificaciones, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, correoNotificaciones);
            return "correonotificacioneses/update";
        }
        uiModel.asMap().clear();
        correoNotificacionesService.updateCorreoNotificaciones(correoNotificaciones);
        return "redirect:/correonotificacioneses/" + encodeUrlPathSegment(correoNotificaciones.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, correoNotificacionesService.findCorreoNotificaciones(id));
        return "correonotificacioneses/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        CorreoNotificaciones correoNotificaciones = correoNotificacionesService.findCorreoNotificaciones(id);
        correoNotificacionesService.deleteCorreoNotificaciones(correoNotificaciones);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/correonotificacioneses";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("correoNotificaciones_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("correoNotificaciones_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, CorreoNotificaciones correoNotificaciones) {
        uiModel.addAttribute("correoNotificaciones", correoNotificaciones);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("escuelas", escuelaService.findAllEscuelas());
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
